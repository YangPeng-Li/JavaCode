package io.netty.nio;


/**
 * NIO 示例
 * 
 * 在任务管理器中可以看到Javaw.exe 线程只有一个	
 * @author Lyp
 * @date 2018年12月20日
 * @version 1.0
 *
 */

public class TimeClient {

			
		public static void main(String[] args) {
			
			int port = 8888;
			if(args !=null && args.length>0)
			{
				try {
					port = Integer.valueOf(port);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			TimeClientHandle timeServer = new TimeClientHandle("127.0.0.1",8888);
			new Thread (timeServer,"QUERY TIME ORDER").start();;
		}
}
