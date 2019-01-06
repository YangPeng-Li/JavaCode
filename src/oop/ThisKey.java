package oop;

/*
 * this ：
 * 1.可以用来修饰属性、方法、构造器
 * 2.this理解为当前对象或当前正在创建的对象
 * 3.可以在构建器中通过”this(形参)“的方式
 */



public class ThisKey {

}
class Person {
	private String name;
	private int age;
	
	public  Person() {}
	public Person (String n) {}
	
	public String setName(String name)
	{
		return name;
	}
	public void info () {
		System.out.println();
	}
}