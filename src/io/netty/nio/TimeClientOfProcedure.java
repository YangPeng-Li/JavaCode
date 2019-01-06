package io.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeClientOfProcedure {
	
	public static void main(String[] args) throws IOException {
		
		/*		Selector selector;
		int port = 8080;
		int BUFFER_SIZE = 1024;
		Socket socket ;
		//步骤一	 打开SocketChannel，绑定客户端本地地址
		SocketChannel clientChannel = SocketChannel.open();
		
		//步骤二	设置SocketChannel为非阻塞模式，同时设置客户端连接的TCP参数，
			
		
			clientChannel.configureBlocking(false);
			socket.setReuseAddress(true);
			socket.setReceiveBufferSize(BUFFER_SIZE);
			socket.setSendBufferSize(BUFFER_SIZE);
			//步骤三		 异步连接服务端
			boolean connection  =   clientChannel.connect(new InetSocketAddress("ip",port));
			
			//步骤四	判断是否连接成功，如果连接成功则直接注册读状态到多路复用器中，如果当前没有连接成功
			//		(异步连接，返回false ,说明客户端已经发送sync包，服务端没有返回ack包，物理链路没有建立)
			if(connection)
			{
				clientChannel.register(selector, SelectionKey.OP_READ, ioHandler);
			}
			else
			{
				clientChannel.register(selector, SelectionKey.OP_CONNECT, ioHandler);
			}
			//步骤五:		 向Reactor线程的多路复用器注册OP_CONNECT状态位，监听服务端的TCP ACK应答
			clientChannel.register(selector, SelectionKey.OP_CONNECT, ioHandler);
			//步骤六：		创建Reactor线程，创建多路复用器并启动线程
			Selector selector2 = Selector.open();
			new Thread(new ReactorTask()).start();
			//步骤七 ： 多路复用器在线程run 方法的无限循环体内轮询准备就绪的key 
			int num = selector2.select();
			Set<SelectionKey> selectedKeys = selector2.selectedKeys();
			 Iterator<SelectionKey> iterator = selectedKeys.iterator();
			 while (iterator.hasNext())
			 {
				 SelectionKey next = iterator.next();
			 }
			//步骤八： 		接受connect时间处理
			 if(key.isConnectable())
			 {
//				 handleConnect();
			 }
			 
			 //步骤九：	判断连接结果，如果连接成功，注册读事件到多路复用器
			 if (channel.finishConnect())
				 registerRead();
			 
			 //步骤十：	注册事件到多路复用器上
			 clientChannel.register(sel, ops, att);
			 
			 //步骤十一：异步读取客户端请求到缓存区
			  int readNum =channel.read(receiveBuffer);
			  //步骤十二：		对byteBuffer进行编码，如果有半包消息接收缓冲区Reset,继续读取后续的报文
			  //			将解码成功的消息封装成Task,投递到线程池中进行业务逻辑编排
			 Object message = null;
			 while (buffer.hasRemain())
			 {
				 byteBuffer.mark();
				 Object message = decode(byteBuffer);
				 if(message == null)
				 {
					 byteBuffer.reset();
					 break;
					 
					 messageList.add(message);
				 }
			 }
			 if (!byteBuffer.hasRemain())
				 byteBuffer.clear();
			 else
				 byteBuffer.compact();
			 
			 if (messageList !=null && messageList.isEmpty())
			 {
				 for (Object messageE :messageList)
					 handlerTask(messageE);
			 }
			 
			 //步骤十三：		将Pojo对象encode成ByteBuffer,调用SocketChannel的异步write接口将消息发送给客户端
				socketChannel.write(buffer);*/
			 
			 
	}
	

	private static void selectedKeys() {
		// TODO Auto-generated method stub
		
	}


	private static void connect(InetSocketAddress inetSocketAddress) {
		// TODO Auto-generated method stub
		
	}

	
}
