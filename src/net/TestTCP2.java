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
 * TCP编程例二：客户端给服务器发送信息，服务端将信息打印在控制台上，同时发送“已收到信息”给客户端
 * 
 * 如下的程序：处理异常时，要使用try-catch-finally 
 */
public class TestTCP2 {

	// 客户端
	@Test
	public void client() {
		Socket sc = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			//1.创建socket对象
			sc = new Socket(InetAddress.getByName("127.0.0.1"), 8989);
			//2.从本地获取一个文件发送给服务端
			os = sc.getOutputStream();
			os.write("我是客户端".getBytes());
			//告诉服务端信息已经发送完毕不用在读取信息
			sc.shutdownOutput();
			//3.接受来自服务端的信息
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
		// 4.关闭流和socket对象
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

	// 服务端
	@Test
	public void Service() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			//1.创建一个ServerSocket对象
			ss = new ServerSocket(8989);
			//2.调用其accept()方法
			s = ss.accept();
			//3.将从客户端发送过来的信息保存到本地
			is = s.getInputStream();
			byte[] b = new byte[20];
			int len;
			//fileInputStream block
			//不知道什么时候发完
			while ((len = is.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.println(str);
			}
			//4. 发送“接受成功”的信息
			os = s.getOutputStream();
			os.write("服务端已收到信息".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//5.关闭相应的流和Socket以及ServerSocket的对象
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
