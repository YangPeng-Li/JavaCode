package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;


//TCP�ͻ��˵ı����һ �ͻ��˷�����Ϣ�������
//������ʵ���Ͼ���Socket
public class TestTCP1 {

	
	@Test
	public void client ()  {
		Socket socket = null;
		OutputStream os = null;
		try {
			//1.����һ��Socket�Ķ���ͨ���������ƶ�������IP��ַ�Լ����ܳ���Ķ˿�
			 socket = new Socket(InetAddress.getByName("127.0.0.1"),6789);
			 //2.getOutputStream()����������OutputStream�Ķ���
			 os=  socket.getOutputStream();
			 //3.������������
			os.write("���ǿͻ���".getBytes());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			//�ر���socket ����
			if(os != null)
			{
				
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(socket !=null)
			{
				
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Test 
	public void service() {
		
		ServerSocket ss =null;
		Socket s = null;
		InputStream is =null;
		try {
			//1.����һ��ServerSocket�Ķ���ͨ������������Ķ˿ں�
			ss = new ServerSocket(6789);
			//2.������Accept()����һ��socket�Ķ���
			s = ss.accept();
			//3.����Socket�����getInputStream()��ȡһ���ӿͻ��˷���������������
			is = s.getInputStream();
			//4.���ȡ�����������в���
			byte [] b = new byte[20];
			int len;
			while ((len = is.read(b)) !=-1) {
				String str = new String (b,0,len);
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//5.�ر���Ӧ������ Socket ServerSocket�Ķ���
			if(is!=null)
			{
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(s !=null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ss !=null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
}
