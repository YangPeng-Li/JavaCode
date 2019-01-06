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
	// 有了反射可以通过创建一个类的第项，并调用其中的结构
	
	
	//类加载器
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
	
	String className = "java.lang.Object"; //和心类
	Class clazz2 = Class.forName(className);
	ClassLoader loader5 = clazz2.getClassLoader();
	System.out.println("loader5:"+loader5);
	
	//掌握如下
	
	
	//ClassLoader loader=  this.getClass().getClassLoader();
	//InputStream is =  loader.getResourceAsStream("g13\\jdbc.properties");
	
	//法二
	FileInputStream is = new FileInputStream(new File("jdbc1.properties"));//当前工程下
	
	Properties pros = new Properties();
	pros.load(is);
	String name = pros.getProperty("name");
	System.out.println(name);
	
	}
	
	
	//如何获取Class的实例（3种）
	@Test
	public void test() throws Exception {
		//1.调用运行时类本身.class属性
		Class clazz1 = Person.class;
		System.out.println(clazz1.getName());
		
		Class clazz2 = String.class;
		System.out.println("1.调用运行时类本身.class属性"+clazz2.getName());
		
		
		//2.通过运行时类的对象获取
		Person p  = new Person();
		Class clazz3 = p.getClass();
		System.out.println("2.通过运行时类的对象获取"+clazz3.getName());
		
		//3.通过Class的静态方法获取,通过此方法体会动态代理
		String className = "g13.Person";
		Class clazz4 = Class.forName(className);
		//clazz4.newInstance();
		System.out.println("3.通过Class的静态方法获取"+clazz4.getName());
		
		
		//4. 通过类的加载器
		ClassLoader classLoader =	this.getClass().getClassLoader();
		Class clazz5 = classLoader.loadClass(className);
		System.out.println(clazz5);
	}
	/*
	 * java.lang.Class 反射源头
	 * 我们创建一个类，通过编译生（java.exe）成对应.calss文件,
	 * 之后我们使用java.exe加载（JVM 的类加载器完成）
	 * 此.class文件,此.class文件加载到内存以后就是一个运行时类，存放在缓存区，
	 * 那么这个运行是类本身就是Class的实例
	 * 1）每一个运行时类，只加载一次
	 * 2）获取对应的运行是类的完整结构（属性、方法、内部类、父类、包、异常、注解）
	 * 3）调用对应的运行时类的指定的结构（属性、方法、构造器）
	 * 4）反射的应用：动态代理
	 * 
	 * 
	 * 
	 */
	public void test3(){
		Person p = new Person();
		Class clazz  = p.getClass();//通过运行时类的对象，调用其getClass(),返回其类
	}
	
	
	
	@Test
	public void test2() throws Exception {
		Class clazz = Person.class;
		
		// 1.创建clazz 对应运行是类Person类的对象
		Person p = (Person) clazz.newInstance();
		
		//通过反射调用运行时指定的属性
		Field f1 = clazz.getField("name"); //属性修饰类型需为public
		f1.set(p, "刘德华"); 
		System.out.println(p);
		
		//2
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p, 20);
		System.out.println(p);
		
		//3.通过反射嗲用运行时类的指定方法
		Method m1 = 	clazz.getMethod("show");
		m1.invoke(p);
		
		Method m2 = 	clazz.getMethod("display",String.class);
		m2.invoke(p, "China");
		
	}

	// 再有反射以前，如何创建一个类的对象，并调用其中的方法、属性
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
