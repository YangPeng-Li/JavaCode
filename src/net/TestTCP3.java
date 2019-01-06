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
 * TCP3 客户端发送本地文件到服务端，服务端保存到本地，并返回发送成功，并关闭相应连接
 */
public class TestTCP3 {

	@Test
	public void Clicent() {
		Socket so = null;
		FileInputStream fi = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			//创建一个socket对象
			so = new Socket(InetAddress.getByName("127.0.0.1"), 9911);
			//2.从本地获取一个文件写入流中
			fi = new FileInputStream(new File("1.png"));
			os = so.getOutputStream();
			byte[] b = new byte[1024];
			int len;
			while ((len = fi.read(b)) != -1) {
				os.write(b, 0, len);
			}
			//关闭socket 字节流易阻塞
			so.shutdownOutput();
			//3.接受来自服务端
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
		//关闭流和socket对象
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
			//1.创建服务端的Socket
			ss = new ServerSocket(9911);
			//2.调用其accept()方法接受客户端的消息
			s = ss.accept();
			//3.将从客户端发送过来的信息保存到本地
			is = s.getInputStream();
			fos = new FileOutputStream(new File("2.png"));
			byte[] b = new byte[1024];
			int len;
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			System.out.println("收到来自于"+s.getInetAddress().getHostName()+"的消息/文件");
			//4. 发送“接受成功”的信息
			os = s.getOutputStream();
			os.write("图片发送成功！".getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//5.关闭相应的流和Socket及ServerSocket的对象
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
