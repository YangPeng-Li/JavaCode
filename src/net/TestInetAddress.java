package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*网络通信 第一要素：通过IP地址，唯一的定位互联网上主机
 * InetAddress:位于Java.net
 * 1.InetAddress用来代表IP地址，一个InetAdress的对象
 * 代表一个IP地址
 * 2.如何创建InetAddress的对象 。getByName(String host)
 * 3.getHostName()
 * 	getHostAddress()
 */
public class TestInetAddress {
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress inet = InetAddress.getByName("www.gulixueyuan.com");
		
		
		System.out.println(inet);
		System.out.println(inet.getHostName());
		System.out.println(inet.getHostAddress());
		
		
		InetAddress inte1 = InetAddress.getLocalHost();
		System.out.println(inte1);
		System.out.println(inte1.getHostName());
		System.out.println(inte1.getHostAddress());
	}
}
