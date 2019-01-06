package reflect;

import java.lang.reflect.Field;

import org.junit.Test;

public class TestReflect {
	
//������ļ�����
	@Test
	public void test5() {
		//ϵͳ�������
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
	  * ��λ�ȡ���Class��ʵ������
	  * 
	  */
		@Test
		public void test4() throws ClassNotFoundException
		{ 
			//1.��������ʱ�౾���.class����
			Class clazz  = Person.class;
			System.out.println(clazz.getName());
			
			Class clazz1 =	String.class;
			System.out.println(clazz1.getName());
			
			//2. ͨ������ʱ��Ķ����ȡ
			Person p = new Person();
		    Class clazz2	= p.getClass();
			
		    System.out.println(clazz2.getName());
			
		    
		    //3.ͨ��Class�ľ�̬������ȡ(ͨ���η�����ᶯ̬����)
		    String className = "reflect.Person";
		    Class class3 =    Class.forName(className);
		    System.out.println(class3.getName());
		    
		    //4.�˽���ļ�����
		    ClassLoader classloader = this.getClass().getClassLoader();
		    Class clazz4 =   classloader.loadClass(className);
		    System.out.println(clazz4.getName());
		}
	
	
	
	
	
	
	
	
		/*
		 * Java.lang.class ���Ƿ����Դͷ
		 * ���Ǵ�����һ���࣬ͨ�����루javac.exe�����ɶ�Ӧ�ġ�class�ļ���֮��ʹ��java.exe���أ�JVM���������ɵģ���.class�ļ�
		 * �ˡ�class�ļ����ص��ڴ��ļ��Ժ󣬾�������ʱ�࣬���ڻ���������ô�������ʱ�౾�����һ��Class��ʵ��
		 * 1.ÿһ������ʱ��ֻ����һ�Σ�
		 * 2.���˴��Class��ʵ�����ſ��Խ������µĲ���
		 * 	1��������Ӧ������ʱ��Ķ���
		 *  2�����Ի�ȡ��Ӧ����ʱ��������Ľṹ�����ԡ����������������ڲ��ࡢ���ࡢ���ڰ����쳣��ע�⣩
		 *  3�����ö�Ӧ������ʱ��ָ���Ľṹ�����ԡ���������������
		 *  4�������Ӧ�ö�̬����
		 * 
		 */
	
	
	

	@Test
	public void test2 () throws Exception
	{
		Class clazz = Person.class;
		//1.����clazz��Ӧ����ʱ���Person��Ķ���
	 	
		Person p = (Person) clazz.newInstance();
		System.out.println(p);
		//2.ͨ�������������ʱ���ָ������
		Field f1 = clazz.getField("name");
		f1.set(p, "�µ���");
		System.out.println(p);
		//private proteted

		
		Field f2 =  clazz.getDeclaredField("age");
	 	f2.setAccessible(true);
	 	f2.set(p, "19");
	 	System.out.println(p);
	 	
	 	
	}
	
	
	
}
