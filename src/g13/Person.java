package g13;

public class Person {
	public  String name;
	private int age;
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
	
	public  void show() {
		System.out.println("这是个人的类");

	}
	public void display(String nation) {
		System.out.println("我的国际时"+nation);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	
}
