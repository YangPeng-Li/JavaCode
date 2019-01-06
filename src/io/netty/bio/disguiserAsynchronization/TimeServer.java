package io.netty.bio.disguiserAsynchronization;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import io.netty.bio.TimeServerHandle;

/**
 * 实现伪异步（DisguiserOfAsynchronization）
 * 
 * @author Lyp
 * @date 2018年12月19日
 * @version 1.0
 *
 */
public class TimeServer {
	
	public static void main(String[] args) throws IOException {
		
		int port  = 8080;
		if (args !=null && args.length>0)
		{
			try {
				port = Integer.valueOf(port);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ServerSocket  server = null;
		
		try {
			server = new ServerSocket(port);
			System.out.println("The time server is start in port : "+port);
			Socket socket = null;
			TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool (50,1000); //创建I/O任务线程池
			while (true)
			{
				socket = server.accept();
				singleExecutor.execute(new TimeServerHandle(socket));
			}
		} finally
		{
			if (server !=null)
			{
				System.out.println("The time server close");
				server.close();
				server = null;
			}
		}
	}

	
	
	/*	
	 * read() 
	 * This method will block until a character is
	 * available, an I/O error occurs, or the end of the stream is reached.
	 * 此法将会阻塞直到获得字符串  或者 流到达  ，一个I/O错误
	 * 
	 * 有数据可读
	 * 可用数据读取完毕
	 * 发生空指针异常
	 * 
	 * 这一位置对方发送请求或者应答消息比较慢的，或者网络传输较慢时，读取输入流一方的通信时间将被长时间阻塞，
	 * 如果对方要60s才能将数据发送完，读取一方分I/O也将会阻塞60s,再次期间，其他接入消息只能在消息队列中排队
	 * 
	 * 当调用OutputStream 的wrter 方法写输出流的时候，他将会被阻塞，直到所要发送的字节全部如入完毕，或者发生异常，
	 * 在TCP/IP 协议中当消息接受哦处理缓慢的时候，将不能及时地从TCP缓冲区读取数据，这将会导致发送方的TCP window size不断缩小 直到为0
	 * 双方处于 Keep-Alive 状态，消息发送方不能再向TCP缓存去写入消息，
	 * 这时如果采用的是同步阻塞I/O,WRITE 操作将会被无限期阻塞，直到TCP window size大于0 或者发生I/O异常
	 * 
	 * 
	 * 通过输入和输出流的API文档进行分析，了解到读和写操作都是同步阻塞的，阻塞的时间取决于对方的I/O线程的处理速度和网络I/O的传输速度
	 * 本质上讲，我们无法保证生产环境的网络状态和对端的应用程序足够快，如果我们的应用程序依赖对方的处理速度，它的可靠性就非常差，但是一旦上线，
	 * 面对恶劣的网络环境和良莠不齐的第三方系统，问题就会喷发出来。
	 * 
	 * 伪异步I/O实际上仅仅是对之前I/O线程模型的一个简单优化，他无法从根本上解决同步I/O导致的通信阻塞问题。
	 * 分析通信对方返回应答时间过长会引起的级联故障
	 * 1）服务端处理缓慢，返回应答消息耗费60s,平时只要10ms
	 * 2)采用伪异步I/O的线程在读取故障服务节点的响应，由于读取输入流是阻塞的，他将会被同步阻塞60s
	 * 3)假如所有的key那个线程都被故障服务器阻塞，那后续所有的I/O消息都在消息队列中排队
	 * 4）由于线程池采用阻塞队列实现，当队列积满之后，后续如队列的操作将被阻塞
	 * 5）由于前端只有一个Accptor 线程接受客户端接入，它被阻塞在线程池的同步阻塞队列之后，新的客户端请求消息将被拒绝，客户端发送大量连接超时
	 * 6）由于机会所有的连接都超时，调用者会认为系统已经崩溃，无法接受新的请求消息
	 */
	
	
}
