package annotationDemo;

import java.util.ArrayList;
import java.util.List;

/*
 * Annotation其实就是代码的特殊标记，这些标记可以在编码，类加载，运行时被读取，并执行相应的处理
 * 通过使用Annotation，程序员可以在不改变原有逻辑的情况下，在源文件中
 * 嵌入一些补充信息
 * 
 * 
 * Annotation 可以向修饰符一样被使用，可以用于修饰包，类，构造器，方法
 * 成员变量，参数，局部变量的声明，这些些信息被保存在Annotation
 * 能被用来为程序元素（类、方法、成员变量）设置元数据
 * 
 * 
 * 
 * 1.基本注解类型
 * @Override：限定重写
 * @Deprecated ：表示程序元素已过时
 * @SuppressWarnings 抑制编译器警告
 * 2.如何自定义一个注解
 * 3.元注解
 * 
 */
public class Annotation {
	
	public static void main(String[] args) {
		Person p = new Student();
		p.walk();
		p.eat();
		@SuppressWarnings({"rawtypes","unused"})
		List list =  new ArrayList();
	}
}

class Person{
	String name;
	int age;
	@Deprecated
	public void eat()
	{
		System.out.println("吃饭");
	}
	public void walk() {
		System.out.println("走路");
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
class Student extends Person{

	@Override
	public void walk() {
		System.out.println("学生走路");
	}
	
	public void eat() {
		System.out.println("学生吃饭");
	}
	
	
}