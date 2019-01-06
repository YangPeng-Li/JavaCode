package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.junit.Test;

public class TestTCP4 {
	@Test
	public void client() {
		Socket s = null;
		OutputStream os = null;
		Scanner scanner = null;
		// �������Է���˵�����
		InputStream is = null;
		try {
			// 1.����һ��Socket����
			s = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
			// 2.��sд�뵽����
			os = s.getOutputStream();
			// 3.�ͻ��˷�����Ϣ�������
			System.out.println("�������ı��ַ�");
			scanner = new Scanner(System.in);
			String str = scanner.next();
			os.write(str.getBytes());
			s.shutdownOutput();
			is = s.getInputStream();
			byte[] b = new byte[10];
			int len;
			while ((len = is.read(b)) != -1) {
				String str1 = new String(b, 0, len);
				System.out.println(str1);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (scanner != null) {
				scanner.close();
			}
			if (os != null) {
				try {
					os.close();
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

		}

	}

	@Test
	public void Server() {
		ServerSocket ss = null;
		// 2.
		Socket s = null;
		// 3.
		InputStream is = null;
		OutputStream os = null;
		try {
			ss = new ServerSocket(9090);
			s = ss.accept();
			is = s.getInputStream();

			byte[] b = new byte[10];
			int len;
			String str = new String();
			while ((len = is.read(b)) != -1) //
			{
				String str1 = new String(b, 0, len); // ������10�� ��strֻ�����е�һ����
				str += str1; // �ֲ�����ת��Ϊ��Ա����
			}
			String strupperCase = str.toUpperCase();
			os = s.getOutputStream();
			os.write(strupperCase.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
			if (ss != null) {
				try {
					ss.close();
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

		}

	}
}
