package io.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * 
 * @author Lyp
 * @date 2018��12��19��
 * @version 1.0
 *	
 *	�ͻ���ͨ��Socket ���� ���Ͳ�ѯʱ��������ġ�QUERY TIME ORDER��ָ��
 *	Ȼ���ȡ����˵���Ӧ���������ӡ���������ر����ӣ��ͷ���Դ��
 */
public class TimeClient {
	
	public static void main(String[] args) {
		int port = 8080;
		if (args !=null && args.length>0 )
		{
			try {
				port =Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			socket = new Socket ("127.0.0.1",port);
			in = new BufferedReader(new InputStreamReader (socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			out.println("QUERY TIME ORDER");
			System.out.println("Second Order 2 server succeed.");
			String resp = in.readLine();
			System.out.println("Now is "+resp);
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			if(out !=null)
			{
				out.close();
				out = null;
			}
			
			if(in != null)
			{
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			socket = null;
		}
		
		
	}
}
/*
 * BIO ��������ÿ����һ���ͻ��������ʱ������˱��봴��һ���µ��̴߳����½���Ŀͻ��˶����ӣ�һ���߳�ֻ�ܴ���һ��һ���ͻ��˵����ӡ�
 * �ڸ����ܵķ�����Ӧ�������ǳ�ǧ����ĸ߲�������
 * 
 * �ݽ���
 *  ͨ���̳߳ػ�����Ϣ����ʵ��һ�����߶���̴߳���N���ͻ��˵�ģ��
 * 
 */


