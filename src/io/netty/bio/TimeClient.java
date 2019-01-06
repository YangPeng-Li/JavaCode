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
 * @date 2018年12月19日
 * @version 1.0
 *	
 *	客户端通过Socket 创建 发送查询时间服务器的“QUERY TIME ORDER”指令
 *	然后读取服务端的响应并将结果打印出来，随后关闭连接，释放资源。
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
 * BIO 的问题在每当由一个客户请求接入时，服务端必须创建一个新的线程处理新接入的客户端端连接，一个线程只能处理一个一个客户端的连接。
 * 在高性能的服务器应用领域，是成千上万的高并发连接
 * 
 * 演进：
 *  通过线程池或者消息队列实现一个或者多个线程处理N个客户端的模型
 * 
 */


