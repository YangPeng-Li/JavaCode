package reflect;

import java.lang.reflect.Field;

import org.junit.Test;

public class TestReflect {
	
//关于类的加载器
	@Test
	public void test5() {
		//系统类加载器
		ClassLoader loader1 = ClassLoader.getSystemClassLoader();
		System.out.println(loader1);
		
		//
		ClassLoader loader2 = loader1.getParent();
		System.out.println(loader2);
		
		//
		ClassLoader loader3 = loader2.getParent();
		System.out.println(loader3);
	}
	
	
	
	
	
	/*
	  * 如何获取大的Class的实例三种
	  * 
	  */
		@Test
		public void test4() throws ClassNotFoundException
		{ 
			//1.调用运行时类本身的.class属性
			Class clazz  = Person.class;
			System.out.println(clazz.getName());
			
			Class clazz1 =	String.class;
			System.out.println(clazz1.getName());
			
			//2. 通过运行时类的对象获取
			Person p = new Person();
		    Class clazz2	= p.getClass();
			
		    System.out.println(clazz2.getName());
			
		    
		    //3.通过Class的静态方法获取(通过次方法体会动态代理)
		    String className = "reflect.Person";
		    Class class3 =    Class.forName(className);
		    System.out.println(class3.getName());
		    
		    //4.了解类的加载器
		    ClassLoader classloader = this.getClass().getClassLoader();
		    Class clazz4 =   classloader.loadClass(className);
		    System.out.println(clazz4.getName());
		}
	
	
	
	
	
	
	
	
		/*
		 * Java.lang.class ：是反射的源头
		 * 我们创建了一个类，通过编译（javac.exe）生成对应的。class文件。之后使用java.exe加载（JVM类加载器完成的）此.class文件
		 * 此。class文件记载到内存文件以后，就是运行时类，存在缓存区。那么这个运行时类本身就是一个Class的实例
		 * 1.每一个运行时类只加载一次！
		 * 2.有了大的Class的实例，才可以进行如下的操作
		 * 	1）创建对应的运行时类的对象
		 *  2）可以获取对应运行时类的完整的结构（属性、方法、构造器、内部类、父类、所在包、异常、注解）
		 *  3）调用对应的运行时类指定的结构（属性、方法、构造器）
		 *  4）反射的应用动态代理
		 * 
		 */
	
	
	

	@Test
	public void test2 () throws Exception
	{
		Class clazz = Person.class;
		//1.创建clazz对应运行时类的Person类的对象
	 	
		Person p = (Person) clazz.newInstance();
		System.out.println(p);
		//2.通过反射调用运行时类的指定属性
		Field f1 = clazz.getField("name");
		f1.set(p, "陈道明");
		System.out.println(p);
		//private proteted

		
		Field f2 =  clazz.getDeclaredField("age");
	 	f2.setAccessible(true);
	 	f2.set(p, "19");
	 	System.out.println(p);
	 	
	 	
	}
	
	
	
}
