package io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestFile {

	
	/*
	 * Method
	 * �ٷ����ļ�����
	 * getName()
	 * getPath()
	 * getAbsoluteFile()
	 * getAbsolutepath()
	 * getParent()
	 * renameTo(File newname) 
	 * file1.renameTo(file2):file1����Ϊfile2.Ҫ��file1�ļ�һ������
	 * file2һ��������
	 * 
	 *  * ���ļ���⣺
	 *  exists()
	 *  canWrite()
	 *  canRead()
	 *  isFile()
	 *  isDirectory()
	 *  lastModified
	 *  length()
	 * 
	 * 
	 * �ۻ�ȡ�����ļ���Ϣ
	 * createNewFile()
	 * delete()
	 * mkDir()  �� ����һ���ļ�Ŀ¼��ֻ�����ϲ��ļ�Ŀ¼���ڵ�����£����ܷ���true
	 * mkDirs()	:����һ���ļ�Ŀ¼�����ϲ��ļ�Ŀ¼��������һ������
	 * list()
	 * listFiles()
	 * ���ļ��������
	 * 
	 * Ŀ¼�������
	 *  
	 */
	
	
	@Test
	public void test0()
	{
		//File file1 =  new File("d:/io/hello.txt");
	//	File file1 =  new File("d:\\io\\hello.txt");
		//File file2 = new File("hello.txt");
		File file3 = new File("D:\\111");     
		File file11 = new File("D:\\io\\io3"); 
		
//		System.out.println(file1.getName());
//		System.out.println(file1.getPath());
//		System.out.println(file1.getAbsoluteFile());
//		System.out.println(file1.getParent());
//		System.out.println(file1.getAbsolutePath());
//		
//		System.out.println();
//		System.out.println(file2.getName());
//		System.out.println(file2.getPath());
//		System.out.println(file2.getAbsoluteFile());
//		System.out.println(file2.getParent());
//		System.out.println(file2.getAbsolutePath());
//		
		//renameTo (File newName):
		//file1.renameTo(file2)" //file1���ļ���Ŀ¼�� file2Ҳ���ļ���Ŀ¼��//·������ת��
		//boolean b = file2.renameTo(file1);
		//System.out.println(b);
		
		boolean b1 = file3.renameTo(file11); 
		//file11("D:\\io\\io3") ��io3������  ��file3��"D:\\1111��������ڣ����̷����ɹ�
		System.out.println(b1);
	}
	
	
	@Test 
	public void test1()
	{
		File file1  = new File("D:/io/helloworld.txt");
		File file2 = new File("D:/io/io3");
		
		System.out.println(file1.exists());
		System.out.println(file1.canWrite());
		System.out.println(file1.isFile());
		System.out.println(file1.isDirectory());
		System.out.println(new Date(file1.lastModified()));
		System.out.println(file1.length());
		
		System.out.println("============================");
		System.out.println(file2.exists());
		System.out.println(file2.canWrite());
		System.out.println(file2.isFile());//�Ǹ��ļ�
		System.out.println(file2.isDirectory()); //�Ǹ��ļ�Ŀ¼
		System.out.println(new Date(file2.lastModified()));
		System.out.println(file2.length());
	}
	
	@Test
	public void test2() throws Exception
	{
		
		
		File file3 = new File("D:\\�û�Ŀ¼");
		String[] list  = null;
	           list =	file3.list();
	/*	for (int i=0;i<list.length;i++)
		{
			System.out.println(list[i]);
		}*/
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSSS");
	    
		long startTime = System.currentTimeMillis();
	    Date start1 = new Date(startTime); 
	    String str1 = sdf.format(start1);
	   // for(String i :list)
		for (Object i: list)  //ѭ������ʱ String ������ʱ�����
		{
			System.out.println(i);
		}
		long endTime = System.currentTimeMillis();
		 Date endtime1 = new Date(endTime);
		 String str2 = sdf.format(endtime1);
//		System.out.println(start1);
		System.out.println(endtime1);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("����ʱ��Ϊ��"+(endTime-startTime));
		
		File []  files = file3.listFiles();
		
		for (int i=0;i<files.length;i++)
		{
			System.out.println(files[i].getName());
		}
	}
	
}
