package reflect;

public class Person {
	public String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public void national(String national) {
		System.out.println("我的国籍是："+national);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	} 
	
	
	
}
