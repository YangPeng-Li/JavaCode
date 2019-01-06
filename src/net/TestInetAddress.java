package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*����ͨ�� ��һҪ�أ�ͨ��IP��ַ��Ψһ�Ķ�λ������������
 * InetAddress:λ��Java.net
 * 1.InetAddress��������IP��ַ��һ��InetAdress�Ķ���
 * ����һ��IP��ַ
 * 2.��δ���InetAddress�Ķ��� ��getByName(String host)
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
