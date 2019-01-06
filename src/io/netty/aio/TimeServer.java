package io.netty.aio;

/**
 * NIO 2.0�����µ��첽ͨ��������ṩ���첽�ļ�ͨ�������첽�׽���ͨ����ʵ�֡�
 * �첽ͨ�������ֻ�ȡ�������
 * java.util.current.Future������ʾ�첽�����Ľ��
 * ִ���첽������ʱ����һ��java.nio.channels
 * CompletionHandler �ӿڵ�ʵ������Ϊ������ɵĻص�
 * NIO 2.0 ���첽�׽���ͨ�����������첽������I/O,��Ӧ��UNIX�������е��¼�
 * ����I/O��AIO����������Ҫͨ����·��������Selector����ע���ͨ��������ѯ��������ʵ���첽��д����
 * 
 * 
 * AIO ��ʱ������� ��
 * 
 * @author Lyp
 * @date 2018��12��20��
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
