package net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;


/*
 * URL ͳһ��Դ��λ����һ��URL�Ķ����Ӧ�Ż�������һ����Դ
 * ���ǿ���ͨ��URL�Ķ����������Ӧ�ķ���
 */
public class TestURL {
	public static void main(String[] args) throws Exception {
		//����һ��URL����
		URL url = new URL("http://127.0.0.1:8080/examples/hello.txt"); //�ļ�·��
		//��ȡ��Դ
		/*
		 * getProtocol
		 * getHost
		 * getPort
		 * getPath
		 * getFile
		 * getRef
		 * getQuery
		 */
//		System.out.println(url.getProtocol());
//		System.out.println(url.getPath());
//		System.out.println(url.getHost());
//		System.out.println(url.getPort());
//		System.out.println(url.getFile());
//		System.out.println(url.getRef());
//		System.out.println(url.getQuery());
		//��ν�����˵���Դ��ȡ����
		
		InputStream is =  url.openStream(); 
		byte [] b = new byte [100];
		int len;
		while((len = is.read(b)) !=-1) {
			String str = new String(b,0,len);
			System.out.println(str);
		}
		is.close();
		
		//����������ݵ����룬�������������ʹ��URLConnection
		java.net.URLConnection urlConnection =  url.openConnection();
		InputStream is1 = urlConnection.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("abc.txt"));
		byte [] b1 = new byte [1023];
		int len1;
		while ((len1 = is1.read(b1)) !=-1) {
			fos.write(b1, 0, len1);
		}
		fos.close();
		is1.close();
	}
}
/*
 * Hadoop��Դ�ڢ٢ڡ������ݵĴ洢 HDFS PB��1024TB RADI0 RADI5 
 * ��ͳ���� �ǽṹ�����ݡ�
 */

	//��GFS (Google File System) Google�ļ�ϵͳ
	//��MapReduce ���������� 
	//BigTable Habse 
	
	
