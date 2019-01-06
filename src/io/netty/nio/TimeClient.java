package io.netty.nio;


/**
 * NIO ʾ��
 * 
 * ������������п��Կ���Javaw.exe �߳�ֻ��һ��	
 * @author Lyp
 * @date 2018��12��20��
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
