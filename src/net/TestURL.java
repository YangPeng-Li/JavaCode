package net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;


/*
 * URL 统一资源定位符，一个URL的对象对应着互联网上一个资源
 * 我们可以通过URL的对象调用其相应的方法
 */
public class TestURL {
	public static void main(String[] args) throws Exception {
		//创建一个URL对象
		URL url = new URL("http://127.0.0.1:8080/examples/hello.txt"); //文件路径
		//读取资源
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
		//如何将服务端的资源读取进来
		
		InputStream is =  url.openStream(); 
		byte [] b = new byte [100];
		int len;
		while((len = is.read(b)) !=-1) {
			String str = new String(b,0,len);
			System.out.println(str);
		}
		is.close();
		
		//如果既有数据的输入，又有数据输出则使用URLConnection
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
 * Hadoop来源于①②、大数据的存储 HDFS PB级1024TB RADI0 RADI5 
 * 传统数据 非结构化数据、
 */

	//①GFS (Google File System) Google文件系统
	//②MapReduce 分析大数据 
	//BigTable Habse 
	
	
