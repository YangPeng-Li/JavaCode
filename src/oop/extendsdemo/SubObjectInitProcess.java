package oop.extendsdemo;


/*
 * 子类对象实例化的全过程
 */
public class SubObjectInitProcess {
	public static void main(String[] args) {
		dog  d = new dog();
		d.setAge(10);
		d.setName("花花");
		d.setHostName("小明");
		System.out.println("Name: "+d.getName()+"age: "+d.getAge()+"HostName:"+d.getHostName());
	}
}
class Creator{
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Creator () {
		super();
		System.out.println("this is creator's constructor");
	}
	
	
}
class Animal extends Creator{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal() {
		super();
		System.out.println("this is Animal Constructor");
	}
	
}
class dog extends Animal{
	private String hostName;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public dog() {
		super();
		System.out.println("this is dog's Contructor");
	}
	
}