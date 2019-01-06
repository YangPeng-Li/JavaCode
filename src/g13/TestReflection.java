package g13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;


import org.junit.Test;

public class TestReflection {
	// ���˷������ͨ������һ����ĵ�����������еĽṹ
	
	
	//�������
	@Test
	public void test5() throws ClassNotFoundException, IOException	{
	ClassLoader loader1 = ClassLoader.getSystemClassLoader();
	System.out.println("loader1:"+loader1);
	
	ClassLoader loader2 =	loader1.getParent();
	System.out.println("loader2:"+loader2);
	
	ClassLoader loader3 =	loader2.getParent();
	System.out.println("loader3:"+loader3);
	
	
	Class clazz1 = Person.class;
	ClassLoader	loader4= clazz1.getClassLoader();
	System.out.println("loader4:"+loader4);
	
	String className = "java.lang.Object"; //������
	Class clazz2 = Class.forName(className);
	ClassLoader loader5 = clazz2.getClassLoader();
	System.out.println("loader5:"+loader5);
	
	//��������
	
	
	//ClassLoader loader=  this.getClass().getClassLoader();
	//InputStream is =  loader.getResourceAsStream("g13\\jdbc.properties");
	
	//����
	FileInputStream is = new FileInputStream(new File("jdbc1.properties"));//��ǰ������
	
	Properties pros = new Properties();
	pros.load(is);
	String name = pros.getProperty("name");
	System.out.println(name);
	
	}
	
	
	//��λ�ȡClass��ʵ����3�֣�
	@Test
	public void test() throws Exception {
		//1.��������ʱ�౾��.class����
		Class clazz1 = Person.class;
		System.out.println(clazz1.getName());
		
		Class clazz2 = String.class;
		System.out.println("1.��������ʱ�౾��.class����"+clazz2.getName());
		
		
		//2.ͨ������ʱ��Ķ����ȡ
		Person p  = new Person();
		Class clazz3 = p.getClass();
		System.out.println("2.ͨ������ʱ��Ķ����ȡ"+clazz3.getName());
		
		//3.ͨ��Class�ľ�̬������ȡ,ͨ���˷�����ᶯ̬����
		String className = "g13.Person";
		Class clazz4 = Class.forName(className);
		//clazz4.newInstance();
		System.out.println("3.ͨ��Class�ľ�̬������ȡ"+clazz4.getName());
		
		
		//4. ͨ����ļ�����
		ClassLoader classLoader =	this.getClass().getClassLoader();
		Class clazz5 = classLoader.loadClass(className);
		System.out.println(clazz5);
	}
	/*
	 * java.lang.Class ����Դͷ
	 * ���Ǵ���һ���࣬ͨ����������java.exe���ɶ�Ӧ.calss�ļ�,
	 * ֮������ʹ��java.exe���أ�JVM �����������ɣ�
	 * ��.class�ļ�,��.class�ļ����ص��ڴ��Ժ����һ������ʱ�࣬����ڻ�������
	 * ��ô����������౾�����Class��ʵ��
	 * 1��ÿһ������ʱ�ֻ࣬����һ��
	 * 2����ȡ��Ӧ����������������ṹ�����ԡ��������ڲ��ࡢ���ࡢ�����쳣��ע�⣩
	 * 3�����ö�Ӧ������ʱ���ָ���Ľṹ�����ԡ���������������
	 * 4�������Ӧ�ã���̬����
	 * 
	 * 
	 * 
	 */
	public void test3(){
		Person p = new Person();
		Class clazz  = p.getClass();//ͨ������ʱ��Ķ��󣬵�����getClass(),��������
	}
	
	
	
	@Test
	public void test2() throws Exception {
		Class clazz = Person.class;
		
		// 1.����clazz ��Ӧ��������Person��Ķ���
		Person p = (Person) clazz.newInstance();
		
		//ͨ�������������ʱָ��������
		Field f1 = clazz.getField("name"); //��������������Ϊpublic
		f1.set(p, "���»�"); 
		System.out.println(p);
		
		//2
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p, 20);
		System.out.println(p);
		
		//3.ͨ��������������ʱ���ָ������
		Method m1 = 	clazz.getMethod("show");
		m1.invoke(p);
		
		Method m2 = 	clazz.getMethod("display",String.class);
		m2.invoke(p, "China");
		
	}

	// ���з�����ǰ����δ���һ����Ķ��󣬲��������еķ���������
	@Test
	public void test1() {
		Person p = new Person();
		p.setAge(10);
		p.setName("haha");
		System.out.println(p);
		p.show();
		p.display("HK");
	}

}
