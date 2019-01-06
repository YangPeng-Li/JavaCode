package io.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * 
 * @author Lyp
 * @date 2018年12月20日
 * @version 1.0
 */
public class TimeClientHandle implements Runnable {
	
	private String host;
	private int port;
	private Selector selector;
	private SocketChannel  socketChannel;
	private volatile boolean stop;

	/**
	 * 
	 * ①构造函数用于初始化NIO 的多路复用器和SocketChannel对象。需注意的是
	 * 创建SocketChannel之后，需要将其设置为异步非阻塞模式，设置SocketChannerl的TCP参数，接收和发送的TCP缓冲区大小
	 * 
	 * 
	 * @param host
	 * @param port
	 */
	public TimeClientHandle (String host,int port)
	{
		this.host = host == null ? "127.0.0.1" : host;
		this.port = port;
		
		try {
			selector=Selector.open();
			socketChannel=SocketChannel.open();
			socketChannel.configureBlocking(false);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	@Override
	public void run() 
	{
		/*
		 * ②用于发送连接请求作为示例，连接是成功的，所以不需要重连操作，
			因此将其放到循环之前。
		 */
		try {
			doConnect();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		 * ③在循环体中轮询多路复用器selector 当有就绪的Channel时，执行 handleInput(key)方法
		 */
		
		while (!stop)
		{
			try {
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectedKeys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext())
				{
					key = iterator.next();
					iterator.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if(key !=null)
						{
							key.cancel();
							if(key.channel() !=null)
							{
								key.channel().close();
							}
						}
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		/*
		 * 多路复用器关闭之后，所有注册在上面的Channel和Pipe等资源都会被自动关闭不需要重复释放
		 * 多路复用器的资源释放，由于多路多路复用器上可能注册成千上万的Channel或者pipe
		 * 如果一一对这些资源释放显然不合适的，JDK底层会自动释放所有跟此多路复用器关联的资源	
		 */
		if(selector !=null)
		{
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * ④首先对SelectionKey进行判断，看它处于什么状态，如果处于连接状态，说明服务端已经返回ACK应答消息，这时需要对连接结果进行判断
	 * 调用Socketchannel的finishConnect()方法，如果返回true ,说明客户端连接成功，，false或者直接抛出IOEXception，连接失败
	 * 将SocketChannel注册到多路复用器上，注册SelectionKey.OP_READ操作位，监听网络操作，然后发送请求消息 给服务端
	 * 
	 * 
	 * 	
	 * @param key
	 * @throws IOException
	 */
	private void handleInput(SelectionKey key) throws IOException {
		if (key.isValid())
		{
			SocketChannel sc = (SocketChannel) key.channel();
			if(key.isConnectable())
			{
				if(sc.finishConnect())
				{
					sc.register(selector, SelectionKey.OP_READ);
					doWrite(sc);
				}
				else
				System.exit(1);//连接失败 ,进程退出
			}
			/*
			 * ⑤ 继续分析客户端是如何读取时间服务器应答消息，如果客户端收到服务端应答消息，则SocketChannel是可读,由于实现无法判断应答码流的大小
			 * 我们分配1MB的接收缓存区用于读取应答消息，调用SocketChannel的read()方法进行异步读取操作，由于是异步操作，所以必须对读取的结果进行判断
			 * 读取到了消息，则对消息进行解码，最后打印结果，执行完后将stop置为true,线程退出循环
			 * 
			 */
			
			if(key.isReadable())
			{
				ByteBuffer readBuffer =  ByteBuffer.allocate(1024);
				int readBytes =  sc.read(readBuffer);
				if(readBytes >0)
				{
					readBuffer.flip();
					byte [] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new  String (bytes,"UTF-8");
					System.out.println("Now is"+body);
					this.stop = true;
				}
				else if(readBytes < 0)
				{
					// 对端链路关闭
					key.cancel();
					sc.close();
				}
				else
					;//读到0字节，忽略
			}
		}
	}

	/**
	 * 
	 * 	②如果连接成功，则将SocketChannel注册到多路复用器Selector上，注册Selection.OP_READ，如果没有连接成功，则说明服务端没有返回
 	 *	TCP握手应答消息，但这不代表连接失败，我们需要将SocketChannel注册大多路复用器Selector上，注册SelectionKey.OP_CONNECT
	 *	当服务器返回syn-ack消息后，selector就轮询到这个SocketChannel处于就绪状态
	 *	发送请求消息，读应
	 * @throws IOException
	 */
	private void doConnect() throws IOException {

		if(socketChannel.connect(new InetSocketAddress(host, port)))
		{
			socketChannel.register(selector, SelectionKey.OP_READ);
			doWrite(socketChannel);
		}
		else
			socketChannel.register(selector,SelectionKey.OP_CONNECT);
	}	
	
	
	/**
	 * 我们构造请求消息体，然后对其编码，写入到发送缓冲区中，最后调用SocketChannel的write方法进行发送。由于发送是异步的
	 * 所以存在“半包写”问题，[无处理]，最后通过hasRemaining()方法对发送结果进行判断，如果缓冲区中的消息全部发送完成打印“Send order 2 server”
	 * 
	 * @param sc
	 * @throws IOException
	 */
	private void doWrite(SocketChannel sc) throws IOException {
		byte req [] = "QUERY TIME ORDER".getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
		writeBuffer.put(req);
		writeBuffer.flip();
		sc.write(writeBuffer);
		if(!writeBuffer.hasRemaining())
		{
			System.out.println("Send oreder 2 server succeed");
		}
	}

}
