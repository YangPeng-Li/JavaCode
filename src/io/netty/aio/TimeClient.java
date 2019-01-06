package io.netty.aio;

/**
 * AIO �ͻ��˵�ʵ��
 * 
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
				port=Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		new Thread (new AsyncTimeClientHandler("127.0.0.1",port),"AIO-AsyncTimeClientHandler-001").start();;
		
		
	}
}
