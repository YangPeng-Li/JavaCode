package io.netty.aio;

/**
 * NIO 2.0引入新的异步通道概念，并提供了异步文件通道，和异步套接字通道的实现。
 * 异步通道的两种获取操作结果
 * java.util.current.Future类拉表示异步操作的结果
 * 执行异步操作的时候传入一个java.nio.channels
 * CompletionHandler 接口的实现类作为操作完成的回调
 * NIO 2.0 的异步套接字通道是真正的异步非阻塞I/O,对应于UNIX网络编程中的事件
 * 驱动I/O（AIO）。他不需要通过多路复用器（Selector）对注册的通道进行轮询操作即可实现异步读写操作
 * 
 * 
 * AIO 的时间服务器 端
 * 
 * @author Lyp
 * @date 2018年12月20日
 * @version 1.0
 *
 */

public class TimeServer {
	
	public static void main(String[] args) {
		
		int port = 8888;
		if (args != null && args.length>0)
		{
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		
		AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler (port);
		
		new Thread (timeServer ,"AIO-AsyntimeServerHandler-001").start();;
	}
	
	
	

}
