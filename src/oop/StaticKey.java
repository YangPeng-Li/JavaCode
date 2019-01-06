package oop;

/*
 * static ,静态的，可以用来修饰属性、方法（或者初始化块）、内部类
 * static 修饰属性（类变量）
 * static
 * 
 */



/*关键字Static
 * 1、类和类的创建
 * 		类变量、类方法
 * 		单例设计(Singleton)模式
 * 2.理解main方法
 * 3.类成员的初始化块
 * 4.关键字 final
 * 5.抽象类(abstract class)
 * 	模板方法设计模式(Template Method)
 * 6.更彻底的抽象：接口（Interface）
 * 		工厂方法(FactoryMethod)和代理模式
 * 7.类的成员之五：内部类	
 */

/*
 * static 修饰属性(类变量)：
 * 1.由类创建的所有对象，都共用这一个属性
 * 2.当其中一个对象对此属性进行修改，会导致其他对象对此属性的一个调用。  vs实例变量(非static修饰的属性，都有自己的副本)
 * 3.类变量是随着类的加载而加载的，而且独一份
 * 4.静态的变量可以直接通过“类.类变量”的形式来调用
 * 5.类变量的加载早于对象，所以当有对象以后，可以“对象.类变量”但是“类.类实例变量”是不行
 * 6.类变量存在于静态域中
 * 
 * 
 * 
 *
 *static修饰方法（类方法）
 *1.随着类的加载而加载，在内存中也是独一份
 *2.可以通过“类.类方法”
 *3.内部可以调用静态的属性和静态的方法，而不能调用非静态的属性和方法
 *	反之可以非静态的可以调用静态的属性
 *
 *静态的方法里面是不允许有this或者super
 *
 *注：静态的结构（Static的属性、方法、代码块、内部类）的生命周期要早于非静态，同时被回收晚
 */




public class StaticKey {
	//实例变量（随着对象的创建而被加载的）
	String name;
	int age;
	//类变量
	static String nation;
	public StaticKey(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}



class postMan{
	
	String name;
	int age;
	static String nation;
	public  void show() {
		
	}
	
	public static void show1() {
		info();
	System.out.println("nation"+nation); //nation的生命周期和staic show1相同
	//System.out.println("age:"+this.age); //
	System.out.println();
	}
	
	public static void info() {
		System.out.println("我是静态方法");
	}
}
