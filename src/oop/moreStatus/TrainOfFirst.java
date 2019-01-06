package oop.moreStatus;


/*
 * ¶àÌ¬µÄÁ·Ï° 
 */
public class TrainOfFirst {
	public static void main(String[] args) {
		TrainOfFirst t = new TrainOfFirst();
		t.method1(new Student());
		System.out.println();
		t.method1(new Graduate());
	}
	public  void method1 (Person1 p) {
		System.out.println(p.getInfo());
		
		if(p instanceof Person1) {
			System.out.println("a person");
		}
		if(p instanceof Student){
			System.out.println("A Student");
		}
		if(p instanceof Graduate) {
			System.out.println("A Graduate");
		}
			
	}
}

class Person1 {
	protected String name = "person";
	protected int age  = 50;
	public  String	getInfo(){
		return "Name:"+name+"\n"+"age:"+age;
	}
}

class Student extends Person1{
	protected String school = "pku";
	public String getInfo() {
		return "Name:"+name+"\nage:"+age+"\nschool:"+school;
	}
}


class Graduate extends Student{
	public String major = "IT";
	public String getInfo() {
		return "Name: "+name+"\nage: "+age+"\nschool: "+school+"\nmajor: "+major;
	}
}