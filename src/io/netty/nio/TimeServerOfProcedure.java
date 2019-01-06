package io.netty.nio;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * 
 * @author Lyp
 * @date 2018年12月19日
 * @version 1.0
 * 
 * 概念：
 * NIO：官方称之为New I/O类库 目标是让java 支持非阻塞I/O,更多人称之为非阻塞(Non-block I/O)
 * BIO：(Block IO)
 * 
 * Socket类和ServerSocket 类对应 NIO 提供了SocketChannel 和ServerSocketChannel 两种不同的套接字通道实现
 * 这两种新增的套接字均支持阻塞和非阻塞两种模式
 * 对于低负载，低并发的应用程序可以选择同步阻塞I/O
 * 对于高并发、高负载的网络应用需要使用NIO的非阻塞模式进行开发
 * 
 * 在标准Java 代码中提供了高速的面向块的I/O ,通过定义包含数据的类，以及通过块的形式处理这些数据，NIO 不用使用本地代码就可以利用低级优化，
 *
 * 
 */

public class TimeServerOfProcedure {
	
	public static void main(String[] args) {
	/*	int port = 8080;
		//步骤一：		打开ServerSocketChannel 用于监听客户端的连接，它是所有客户端连接的父管道
		ServerSocketChannel acceptorSvr = ServerSocketChannel.open();
		//步骤二：		绑定监听端口，设置连接为非阻塞模式，
		acceptorSvr.socket().bind(new InetSocketAddress (InetAddress.getByName("IP"),port));
		acceptorSvr.configureBlocking(false);
		//步骤三：		创建Reactor线程，创建多路复用并启动线程
		Selector selector = Selector.open();
		new Thread(new ReactorTask()).start();;
		//步骤四：		将serverSocketChannerl注册到Reactor线程的多路复用器上Selector上，监听Accept事件
		acceptorSvr.register(selector, SelectionKey.OP_ACCEPT,ioHandler);
		//步骤五 ：		多路复用器在线程run方法的无限循环体内 轮询准备就绪的Key,
		int num = 	selector.select();
		Set selectedKeys= selector.selectedKeys();
		Iterator iterator  =selectedKeys.iterator();
		while (iterator.hasNext())
		{
			SelectionKey next = (SelectionKey) iterator.next();
		}
		//	步骤六	多路复用器监听到所有新客户端接入，处理新客户端接入的请求完成TCP三次握手，建立物理链路
		SocketChannel channel = svrchannel.accept();
		
		
		
		//步骤七:		设置客户端的链路为非阻塞模式
		channel.configureBlocking(false);
		channel.socket().setReuseAddress(true);
		//步骤八 :		将新介入到的客户连接注册到Reador线程的多路复用器上，监听读操作，读取客户端发送的网络消息
		SelectionKey key = channel.register(selector, SelectionKey.OP_ACCEPT, ioHandler);
		//步骤九：		 异步读取客户端请求消息到缓存区
		int  readNumber=  channel.read(receivedBuffer);
		//步骤十：		  对ByteBuffer进行编码，如果半包消息指针reset,继续读取后续报文，将解码成功的消息封装成task，投递到业务线程池上，进行业务逻辑编排
		Object message = null;
		while (buffer.hasReman())
		{
			byteBuffer.mark();
			Object message = decode(byteBuffer);
			if (message == null)
			{
				byteBuffer.reset();
				break;
			}
			messageList.add(message);
		}
		if(!byteBuffer.hasRemain())
		byteBuffer.clear();
		else
			byteBuffer.compact();
		if(messageList !=null && messageList.isEmpty())
		{
			for(Object messageE: messageList)
			{
				handlerTask(messageE);
			}
		}
		//步骤十一		将Pojo对象encode成ByteBuffer,调用SocketChannel的异步write接口将消息发送给客户端
		socketChannel.write(buffer);
		*/
		
	}
	
	

}
