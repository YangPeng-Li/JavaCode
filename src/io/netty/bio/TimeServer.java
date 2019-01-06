package io.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * 
 * 
 * @author Lyp
 * @date 2018年12月19日
 * @version 1.0
 */
public class TimeServer {

	
	
	
	private static Logger  logger = Logger.getLogger(TimeServer.class);
	
	/**
	 * 同步阻塞I/O的TimerServer
	 * @param socket
	 */
	
	public static void main(String[] args) throws IOException {
		
		
		int port = 8080 ;
		if (args ==null && args.length >0 )
		{
			try {
				port = Integer.valueOf(args [0]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
		}
		
		ServerSocket server = null;
		try {
			server 	= new ServerSocket (port);
			logger.info("The time server is start in port :"+port);
			Socket socket = null;
			while (true)
			{
				socket = server.accept();
				new Thread (new TimeServerHandle(socket)).start();
			}
		} 
		finally 
		{
			if (server !=null)
			{
				logger.info("The time server is close");
				server.close();
				server = null;
			}
		}
		
	}
}
