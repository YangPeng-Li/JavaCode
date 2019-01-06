package io.netty.nio;

/**
 * 		
 * 
 * @author Lyp
 * @date 2018��12��19��
 * @version 1.0
 *
 */
public class TimeServer {

	/**
	 * 
	 * @param args
	 */
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
		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
		new Thread (timeServer,"NIO-MultiplexerTimeServer-001").start();;
	}
	
}
