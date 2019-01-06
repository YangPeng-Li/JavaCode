package oop.moreStatus;


/*
 * 面向对象特征三：三多态性
 * 
 * 1.多态性指什么？多态性，可以理解为一个事务的多种表现
 * 		1）方法的重载与重写
 * 		2）子类对象的多态(只适应于方法)
 * 2.子类对象多态使用：①要有类的继承 ②子类重写父类的方法
 * 
 * 3.成员运行分为编译状态和运行状态
 * 		对于多态性来说，编译时："看左边"，将此引用变量解释为父类的类型
 * 		运行时，“看右边”专注于真正对象的实体，子类的对象
 * 
 * 4.子类属性的多态性并不适用于多态性
 * 
 */
public class TestPerson {

	public static void main(String[] args) {
		Person p = new Person();
		p.eat();
		p.walk();
		
		man m = new man();
		m.eat();
		m.walk();
		
		
		//子类对象的多态:父类的引用指向子类对象 ,（子类对象指向父类引用）
		
		Person p1 = new man(); //向上转型
		//虚拟方法的调用，通过父类的引用指向子类实体，调用方法时，实际执行的时子类重写父类的方法
		p1.eat();
		p1.walk();
		System.out.println("子父类属判断性的显示："+p1.id);
		
		man m1 = (man)p1; //向下转型
	//	p1.entainment();
		m1.entertainment();
		
		//instanceof
	
		if(p1 instanceof man)
		{
			man m11 = (man)p1;
			m11.entertainment();
		}
	}
	
	public void show (Person p) {
		Person p1  =  new man();
	}
	
}
