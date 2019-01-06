package net;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/*
 * TCP3 �ͻ��˷��ͱ����ļ�������ˣ�����˱��浽���أ������ط��ͳɹ������ر���Ӧ����
 */
public class TestTCP3 {

	@Test
	public void Clicent() {
		Socket so = null;
		FileInputStream fi = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			//����һ��socket����
			so = new Socket(InetAddress.getByName("127.0.0.1"), 9911);
			//2.�ӱ��ػ�ȡһ���ļ�д������
			fi = new FileInputStream(new File("1.png"));
			os = so.getOutputStream();
			byte[] b = new byte[1024];
			int len;
			while ((len = fi.read(b)) != -1) {
				os.write(b, 0, len);
			}
			//�ر�socket �ֽ���������
			so.shutdownOutput();
			//3.�������Է����
			is = so.getInputStream();
			byte[] b1 = new byte[1024];
			int len1;
			while ((len1 = is.read(b1)) != -1) {
				String str = new String(b1, 0, len1);
				System.out.println(str);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//�ر�����socket����
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fi != null) {
				try {
					fi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (so != null) {
				try {
					so.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void Server() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		FileOutputStream fos = null;
		OutputStream os = null;
		try {
			//1.��������˵�Socket
			ss = new ServerSocket(9911);
			//2.������accept()�������ܿͻ��˵���Ϣ
			s = ss.accept();
			//3.���ӿͻ��˷��͹�������Ϣ���浽����
			is = s.getInputStream();
			fos = new FileOutputStream(new File("2.png"));
			byte[] b = new byte[1024];
			int len;
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			System.out.println("�յ�������"+s.getInetAddress().getHostName()+"����Ϣ/�ļ�");
			//4. ���͡����ܳɹ�������Ϣ
			os = s.getOutputStream();
			os.write("ͼƬ���ͳɹ���".getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//5.�ر���Ӧ������Socket��ServerSocket�Ķ���
		finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
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
