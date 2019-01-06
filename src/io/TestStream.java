package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * ����io 
 * ��λ�֣��ֽ�����
 * �ַ��� ��ɫ�֣��ڵ������ļ�������ֱ���������ļ�����������
 */
public class TestStream {
	
	
		@Test
		public void myTest() {
			
			char achar = 'a';
			char enterChar  = '\r';
			char ch = '\u9999';
			char zhong = '��';
			int zhongValue = zhong;
			
			System.out.println(achar);
			System.out.println(enterChar+"\u9991");
			System.out.println(ch);
			System.out.println(zhong);
			System.out.println(zhongValue);
		}
	
	
	
	
	//һͰһͰ�Ķ�ȡ�ڵ㣨�ļ�����
	@Test
	public void testFileInputStream1() throws Exception
	{
		// 1.����File��Ķ���
		// Ҫ��ȡ���ļ�һ������
		File file = new File("hello.txt");
		// 2.����һ��FileInputStram�����
		FileInputStream fis = new FileInputStream(file);
		// 3.����FileInputStream�ķ�����ʵ��file�ļ��Ķ�ȡ
		// read ��ȡ�ļ����ֽڣ�bit��,��ִ�е��ļ���βʱ����ӡ-1
		int b = fis.read();
		while (b != -1) 
		{
			System.out.print((char) b);
			b = fis.read();
		}
		// 4.�ر���Ӧ����
		fis.close(); // ���ֱ�ӽ��쳣�׳�ȥ������Ĵ���ûִ�У���û��һֱ��ռ�����ڴ�
	}

	
	//һ��һ����ȡ�ļ���
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
