package io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestFile {

	
	/*
	 * Method
	 * ①访问文件名：
	 * getName()
	 * getPath()
	 * getAbsoluteFile()
	 * getAbsolutepath()
	 * getParent()
	 * renameTo(File newname) 
	 * file1.renameTo(file2):file1命名为file2.要求file1文件一定存在
	 * file2一定不存在
	 * 
	 *  * ②文件检测：
	 *  exists()
	 *  canWrite()
	 *  canRead()
	 *  isFile()
	 *  isDirectory()
	 *  lastModified
	 *  length()
	 * 
	 * 
	 * ③获取常规文件信息
	 * createNewFile()
	 * delete()
	 * mkDir()  ： 创建一个文件目录，只有在上层文件目录存在的情况下，才能返回true
	 * mkDirs()	:创建一个文件目录，若上层文件目录不存在则，一并创建
	 * list()
	 * listFiles()
	 * ④文件操作相关
	 * 
	 * 目录操作相关
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
		//file1.renameTo(file2)" //file1是文件（目录） file2也是文件（目录）//路径可以转换
		//boolean b = file2.renameTo(file1);
		//System.out.println(b);
		
		boolean b1 = file3.renameTo(file11); 
		//file11("D:\\io\\io3") 的io3不存在  ，file3（"D:\\1111）必须存在，跨盘符不成功
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
		System.out.println(file2.isFile());//是个文件
		System.out.println(file2.isDirectory()); //是个文件目录
		System.out.println(new Date(file2.lastModified()));
		System.out.println(file2.length());
	}
	
	@Test
	public void test2() throws Exception
	{
		
		
		File file3 = new File("D:\\用户目录");
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
		for (Object i: list)  //循环遍历时 String 的运行时间更短
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
		System.out.println("运行时间为："+(endTime-startTime));
		
		File []  files = file3.listFiles();
		
		for (int i=0;i<files.length;i++)
		{
			System.out.println(files[i].getName());
		}
	}
	
}
