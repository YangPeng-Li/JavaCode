package oop.moreStatus;

public class TestDemo {
	
	public static void main(String[] args) {
		TestDemo t = new TestDemo();
		t.func(new Animal());
		t.func(new Dog());
		t.func(new Cat());
	}
	
	public void func (Animal a) { // Animal a = new Dog()/Cat();
		a.eat();
		a.jump();
	}

}
class Animal{
	String name;
	int age;
	public void eat() {
		System.out.println("进食");
	}
	
	public void jump() {
		System.out.println("跳");
	}
}

class Dog extends Animal {
	public void eat() {
		System.out.println("🐕进食");
	}
	
	public void jump() {
		System.out.println("🐶急跳墙");
		
	}
}
class Cat extends Animal {
	  
		public void eat() {
			System.out.println("🐱进食");
		}
		
		public void jump() {
			System.out.println("o(=•ェ•=)爬墙");
	
			}	
}