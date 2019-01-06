package oop.extendsdemo;

/*
 * oop 特征二：继承性
 * 1.为什么要设计继承性？
 * 2.class A extends B 实现类的继承
 * 		子类：A 父类（基类、SuperClass）：B
 * 
 * 3.子类继承父类以后，父类中声明的属性、方法（子类获取到父类的属性name,age但是不能用因为权限限制）
 * 		明确:父类中有私有的属性或方法时，子类同样可以获取到，只是由于封装性，子类无法直接调用
 * 		子类除了通过继承获取父类的结构，还可以自己定义自己的结构
 * 
 * extends: 子类是对父类功能的”扩展“，子类不是父类的子集；
 * 
 * 4.Java的继承只能单继承！一个类只能继承一个类。一个父类可以有多个子类
 * 5.子类和父类时相对概念
 */
public class TestExdents {
	public static void main(String[] args) {
		Student s = new Student();
		s.eat();
		Student  s1 = new Student("PerkingUnivercity");
		System.out.println(s1.getName()+s1.getAge());
		
		Worker w = new Worker();
		w.eat();
	}
}
