package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/*
 * TCP����������ͻ��˸�������������Ϣ������˽���Ϣ��ӡ�ڿ���̨�ϣ�ͬʱ���͡����յ���Ϣ�����ͻ���
 * 
 * ���µĳ��򣺴����쳣ʱ��Ҫʹ��try-catch-finally 
 */
public class TestTCP2 {

	// �ͻ���
	@Test
	public void client() {
		Socket sc = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			//1.����socket����
			sc = new Socket(InetAddress.getByName("127.0.0.1"), 8989);
			//2.�ӱ��ػ�ȡһ���ļ����͸������
			os = sc.getOutputStream();
			os.write("���ǿͻ���".getBytes());
			//���߷������Ϣ�Ѿ�������ϲ����ڶ�ȡ��Ϣ
			sc.shutdownOutput();
			//3.�������Է���˵���Ϣ
			is = sc.getInputStream();
			byte[] b = new byte[20];
			int len;
			while ((len = is.read(b)) != -1) {
				os.write(b, 0, len);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		// 4.�ر�����socket����
		finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sc != null) {
				try {
					sc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	// �����
	@Test
	public void Service() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			//1.����һ��ServerSocket����
			ss = new ServerSocket(8989);
			//2.������accept()����
			s = ss.accept();
			//3.���ӿͻ��˷��͹�������Ϣ���浽����
			is = s.getInputStream();
			byte[] b = new byte[20];
			int len;
			//fileInputStream block
			//��֪��ʲôʱ����
			while ((len = is.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.println(str);
			}
			//4. ���͡����ܳɹ�������Ϣ
			os = s.getOutputStream();
			os.write("��������յ���Ϣ".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//5.�ر���Ӧ������Socket�Լ�ServerSocket�Ķ���
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
