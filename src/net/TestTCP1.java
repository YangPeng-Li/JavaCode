package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;


//TCP客户端的编程例一 客户端发送信息到服务端
//网络编程实际上就是Socket
public class TestTCP1 {

	
	@Test
	public void client ()  {
		Socket socket = null;
		OutputStream os = null;
		try {
			//1.创建一个Socket的对象通过构造器制定服务器IP地址以及接受程序的端口
			 socket = new Socket(InetAddress.getByName("127.0.0.1"),6789);
			 //2.getOutputStream()，方法返回OutputStream的对象
			 os=  socket.getOutputStream();
			 //3.具体的输出过程
			os.write("我是客户端".getBytes());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			//关闭流socket 和流
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
			//1.创建一个ServerSocket的对象，通过构造器自身的端口号
			ss = new ServerSocket(6789);
			//2.调用其Accept()返回一个socket的对象
			s = ss.accept();
			//3.调用Socket对象的getInputStream()获取一个从客户端发生过来的输入流
			is = s.getInputStream();
			//4.多获取的输入流进行操作
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
			//5.关闭相应的流及 Socket ServerSocket的对象
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
