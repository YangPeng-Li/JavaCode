package oop.extendsdemo;

public class Person {
	private String name;
	private int age ;
	int id; //父类与子类重名属性
	
	public Person () {
		System.out.println("this super no arhs Constrcter");
		name = "王五";
		age = 1;
	}
	
	public  Person(String name) {}
	
	public Person (String name, int age) {
		System.out.println(name+age);
	}
	
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
	public void eat() {
		System.out.println("吃");
	}
	public void walk () {
		System.out.println();
	}
}
