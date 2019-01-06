package oop.moreStatus;

public class Person {
	private String  name;
	private int age;
	String	id ="父类属性";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person() {
		super();
	}
	public void  eat() {
		System.out.println("人吃食物");
		
	}
	public void walk () {
		System.out.println("人走了");
	}
	
}
