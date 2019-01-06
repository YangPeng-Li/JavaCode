package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * 流向：io 
 * 单位分：字节流、
 * 字符流 角色分：节点流【文件流】（直接作用于文件）、处理流
 */
public class TestStream {
	
	
		@Test
		public void myTest() {
			
			char achar = 'a';
			char enterChar  = '\r';
			char ch = '\u9999';
			char zhong = '疯';
			int zhongValue = zhong;
			
			System.out.println(achar);
			System.out.println(enterChar+"\u9991");
			System.out.println(ch);
			System.out.println(zhong);
			System.out.println(zhongValue);
		}
	
	
	
	
	//一桶一桶的读取节点（文件流）
	@Test
	public void testFileInputStream1() throws Exception
	{
		// 1.创建File类的对象
		// 要读取的文件一定存在
		File file = new File("hello.txt");
		// 2.创建一个FileInputStram类对象
		FileInputStream fis = new FileInputStream(file);
		// 3.调用FileInputStream的方法，实现file文件的读取
		// read 读取文件的字节（bit）,当执行到文件结尾时，打印-1
		int b = fis.read();
		while (b != -1) 
		{
			System.out.print((char) b);
			b = fis.read();
		}
		// 4.关闭相应的流
		fis.close(); // 如果直接将异常抛出去，后面的代码没执行，流没关一直在占用着内存
	}

	
	//一车一车读取文件流
	@Test
	public void testFileInputStream3() 
	{
		FileInputStream fis = null;
		try {
				File file = new File("hello.txt");
				fis = new FileInputStream(file);
				byte[] b = new byte[20]; //
				int len;
				while ((len = fis.read(b)) != -1)
				{
					for (int i = 0; i < len; i++) 
					{
						System.out.print((char)b[i]);
					}
				}
			} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (fis != null) 
			{
				try 
				{
					fis.close();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testSong () throws IOException
	{
		File f = new File ("Songlist.txt");
		BufferedReader reader = new  BufferedReader (new FileReader(f));
		String line = null;
		while((line = reader.readLine() )!=null)
		{
			String  l = line;
			System.out.println(l);
		}
	}
	
	
	
}
