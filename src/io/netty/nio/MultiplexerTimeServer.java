package io.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * 
 * @author Lyp
 * @date 2018年12月19日
 * @version 1.0 MultiplexerTimeServer
 * 多路复用类，他是一个独立的线程，负责轮询多路复用器Selector,可以处理多个客户端的并发接入。
 *
 */
public class MultiplexerTimeServer implements Runnable {

	private Selector selector;

	private ServerSocketChannel servChannel;

	private volatile boolean stop;

	/**
	 * 初始化多路复用器，绑定监听端口
	 * 
	 * 创建多路复用器selector、ServerSocketChannel、对Channel和TCP参数进行设置
	 * 将ServerSocketChannel设置为异步非阻塞模式，它的backlog设置为1024.
	 * 系统资源初始化成功后，将ServerSocketChannel注册到
	 * selector,监听SelectKey.OP_ACCEPT操作位(例如端口被占用)，则退出
	 * 
	 * @param port
	 */
	public MultiplexerTimeServer(int port) {

		try {

			selector = Selector.open();
			servChannel = ServerSocketChannel.open();
			servChannel.configureBlocking(false);
			servChannel.socket().bind(new InetSocketAddress(port), 1024);
			servChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port:" + port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void stop() {
		this.stop = true;
	}

	/**
	 * 
	 * 在线程的run()方法的while循环体中循环遍历selector ,它的休眠时间为1s 无论是否有读写事件发生，selector每隔1s都被唤醒一次。
	 * selector也提供了一个无参的selector方法：当有处于就绪状态的Channel时，selector将返回该Channel的SelectionKey的集合。
	 * 通过就绪状态的Channel集合进行迭代，可以进行网络的异步读写操作。
	 * 
	 */
	@Override
	public void run() {
		while (!stop) {
			try {
				selector.select(1000);// 它的休眠时间为1s
				Set<SelectionKey> selectKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectKeys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext()) {
					key = iterator.next();
					iterator.remove();

					try {
						handlerInput(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null)
								key.channel().close();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动注册并关闭，所以不需要重复释放资源
		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handlerInput(SelectionKey key) throws IOException {
		/**
		 * 进行处理新接入的客户端请求信息， 根据SelectionKey 的操作进行判断即可获知网络事件类型，
		 * 通过ServerSocketChannel的accpet接受客户端的连接请求并创建 SocketChannel 实例
		 * 完成上述操作后，相当于完成TCP的三次握手，TCP物理链路正式建立。
		 * 将新创建的SocketChannel设置为异步非阻塞，同时也可以对TCP参数进行设置。例如TCP接收和发送缓冲区大小等
		 */
		if (key.isValid()) {
			// 处理新接入的请求消息
			if (key.isAcceptable()) {
				// Accept the new connection
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				// add the new connection to the selector
				sc.register(selector, SelectionKey.OP_READ);
			}

			/*
			 * 用于读取客户端的请求消息，首先创建一个ByteBuffer，由于我们事先无法得知客户端发送的码流大小，
			 * 作为例程，我们开辟一个1MB的缓冲区，然后调用SocketChannel的read方法读取请求码流 注意：
			 * 由于我们将SocketChannel设置为异步非阻塞模式，因此她的read是非阻塞的，使用返回值进行判断，卡到读取的字节数，返回值有以下三种可能结果
			 * 返回值大于0：读到了字节，对字节进行编码 1 ：没有读取到字节，属性正常场景，忽略 -1 ：链路已经关闭，需要关闭SocketChannel,释放资源
			 *
			 * 当读取到码流以后，进行解码，首先对readBuffer进行flip操作，它的作用是将缓冲区的limit设置为position,position设置为0，
			 * 用于后续对缓冲区的读取操作，然后根据缓冲区可读的字节个数创建字节数组，
			 * 调用ByteBuffer的get操作缓冲区可读取的字节数组复制到新创建的字节数组中，最后调用字符串的构造函数创建爱你请求消息并打印
			 * 如果请求指令是“QUERY TIME ORDER”,则把服务器的当前时间编码返回给客户端。
			 */

			if (key.isReadable()) {
				// read the data
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if (readBytes > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("The time server receive order:" + body);
					String currentTime = "QUERY TIME ORDER".equals(body)
							? new Date(System.currentTimeMillis()).toString()
							: "BAD ORDER";
					doWrite(sc, currentTime);
				} else if (readBytes < 0) {
					// 对端链路关闭
					key.cancel();
					sc.close();
				} else {
					;// 读到0字节，忽略
				}
			}
		}

	}

	/*
	 * 将应答消息异步发送给客户端，首先将字符串编码成字节数组，根据字节数组的容量创建ByteBuffer，
	 * 调用ByteBuffer的put操作将字节数组复制到缓冲区中，
	 * 然后对缓冲区进行flip操作，最后调用SocketChannel的write方法，将缓冲区中的字节数组发送出去。需要指出的是，
	 * 由于SocketChannnel是异步非阻塞的，
	 * 他并不保证一次能够把需要发送的字节数组发送完，此时会出现“写半包”问题。我们需要注册写操作，不断轮询selector
	 * 将没有发送完的ByteBuffer发送完毕，
	 * 然后可以通过ByteBuffer的HasRemain()放大判断消息是否发送完成，此处仅仅是个简单的入门级教程，并没有演示如何处理“写半包”场景。
	 * 
	 */

	private void doWrite(SocketChannel channel, String response) throws IOException {
		if (response != null && response.trim().length() > 0) {
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer);
		}
	}

}
