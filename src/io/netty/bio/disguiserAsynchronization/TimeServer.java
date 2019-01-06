package io.netty.bio.disguiserAsynchronization;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import io.netty.bio.TimeServerHandle;

/**
 * ʵ��α�첽��DisguiserOfAsynchronization��
 * 
 * @author Lyp
 * @date 2018��12��19��
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
			TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool (50,1000); //����I/O�����̳߳�
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
	 * �˷���������ֱ������ַ���  ���� ������  ��һ��I/O����
	 * 
	 * �����ݿɶ�
	 * �������ݶ�ȡ���
	 * ������ָ���쳣
	 * 
	 * ��һλ�öԷ������������Ӧ����Ϣ�Ƚ����ģ��������紫�����ʱ����ȡ������һ����ͨ��ʱ�佫����ʱ��������
	 * ����Է�Ҫ60s���ܽ����ݷ����꣬��ȡһ����I/OҲ��������60s,�ٴ��ڼ䣬����������Ϣֻ������Ϣ�������Ŷ�
	 * 
	 * ������OutputStream ��wrter ����д�������ʱ�������ᱻ������ֱ����Ҫ���͵��ֽ�ȫ��������ϣ����߷����쳣��
	 * ��TCP/IP Э���е���Ϣ����Ŷ��������ʱ�򣬽����ܼ�ʱ�ش�TCP��������ȡ���ݣ��⽫�ᵼ�·��ͷ���TCP window size������С ֱ��Ϊ0
	 * ˫������ Keep-Alive ״̬����Ϣ���ͷ���������TCP����ȥд����Ϣ��
	 * ��ʱ������õ���ͬ������I/O,WRITE �������ᱻ������������ֱ��TCP window size����0 ���߷���I/O�쳣
	 * 
	 * 
	 * ͨ��������������API�ĵ����з������˽⵽����д��������ͬ�������ģ�������ʱ��ȡ���ڶԷ���I/O�̵߳Ĵ����ٶȺ�����I/O�Ĵ����ٶ�
	 * �����Ͻ��������޷���֤��������������״̬�ͶԶ˵�Ӧ�ó����㹻�죬������ǵ�Ӧ�ó��������Է��Ĵ����ٶȣ����Ŀɿ��Ծͷǳ������һ�����ߣ�
	 * ��Զ��ӵ����绷������ݬ����ĵ�����ϵͳ������ͻ��緢������
	 * 
	 * α�첽I/Oʵ���Ͻ����Ƕ�֮ǰI/O�߳�ģ�͵�һ�����Ż������޷��Ӹ����Ͻ��ͬ��I/O���µ�ͨ���������⡣
	 * ����ͨ�ŶԷ�����Ӧ��ʱ�����������ļ�������
	 * 1������˴�����������Ӧ����Ϣ�ķ�60s,ƽʱֻҪ10ms
	 * 2)����α�첽I/O���߳��ڶ�ȡ���Ϸ���ڵ����Ӧ�����ڶ�ȡ�������������ģ������ᱻͬ������60s
	 * 3)�������е�key�Ǹ��̶߳������Ϸ������������Ǻ������е�I/O��Ϣ������Ϣ�������Ŷ�
	 * 4�������̳߳ز�����������ʵ�֣������л���֮�󣬺�������еĲ�����������
	 * 5������ǰ��ֻ��һ��Accptor �߳̽��ܿͻ��˽��룬�����������̳߳ص�ͬ����������֮���µĿͻ���������Ϣ�����ܾ����ͻ��˷��ʹ������ӳ�ʱ
	 * 6�����ڻ������е����Ӷ���ʱ�������߻���Ϊϵͳ�Ѿ��������޷������µ�������Ϣ
	 */
	
	
}
