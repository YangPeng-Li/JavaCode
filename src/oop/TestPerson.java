package oop;


/*
 * 1.面向对象的编程专注于类的设计
 * 2.设计类实际上就是设计类的成员
 * 3.基本的类的成员：属性（field，成员变量） & 方法（Method）
 * 
 * This：
 * 1.可以用来修饰属性、返回发、构造器
 * 2.this理解为当前对象或当前正在创建的对象。
 * 3.可以在构造器中通过”this(形参)的方式显示的调用本类中其他重载的指定的构造器
 * 			1).要求构造器必须声明在首行
 * 			2)(n个构造器最多只能调用n-1个方法)
 */


public class TestPerson {

	//类，抽象的 ---->汽车图纸
	class Person {
		//field 属性
		String name;
		int age;
		boolean sex;
		public Person () {
			
		}
		public Person(int age) {
			this.age = age;
		}
		public Person(String name) {
			System.out.println("这是Person类中形参为name的构造器");
			this.name = name; 
		}
		/*this.name表示正在创建的对象
		name 形参 */
		public Person (int age,String name) {
		//this():可以用来显示的调用当前类的重载的指定的构造器
		//this.name= name;
			this(age);  //必须放在第一行
			this.age =age;
			System.out.println("这是Person类中形参为name和age的构造器");
		}
		
		//2.方法
		public void eat(){
			System.out.println("Person eat");
		}
		public void sleep() {
			System.out.println("Person sleep");
		}
		
		public String getName() {
			return name;
		}
		public void SetName(String n) {
			name = n;
		}
		
		public void info() { 
			eat();
			sleep();
			System.out.println("name"+name+"age"+age+"sex"+sex);
		}
	}
	
	
}
