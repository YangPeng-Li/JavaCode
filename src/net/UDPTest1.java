package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.junit.Test;

public class UDPTest1 {
	
	@Test
	public void send () {
		DatagramSocket ds = null;
	try {
		 ds = new DatagramSocket();
		byte[] b = "我是要发送的数据".getBytes();

		DatagramPacket dp =  new DatagramPacket(b,0,b.length,InetAddress.getByName("127.0.0.1"),8989);
		ds.send(dp);
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if( ds !=null)
		{
			ds.close();
		}
	}
	}
	@Test
	public void receive() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(8989);
			
			byte[] b =new byte[1024];
			DatagramPacket dp = new DatagramPacket(b,0,b.length);
			ds.receive(dp);
			
			String str = new String (dp.getData(),0,dp.getLength());
			System.out.println(str);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(ds !=null) {
				ds.close();
			}
		}
	}

}
