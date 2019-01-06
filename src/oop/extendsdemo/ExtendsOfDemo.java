package oop.extendsdemo;

public class ExtendsOfDemo  {

}
class Student extends Person {
	/*
	 * super可以用来修饰属性方法构造器
	 * 1）当子类与父类中同名属性时，可以通过super.属性显式的调用 
	 * 		调用子类同名属性 this.属性
	 * 2）当子类重写父类方法 （重名的）super.方法名()
	 * 
	 * 3)super修饰构造器：通过在子类使用super(形参列表)来显示的调用指定的构造器
	 * 		>在构造器内部：“super（形参列表）”必须声明在首行
	 * 		>super 和this 只能有一个存在
	 * 		>当构造器中不显示的调用this() 或super() 默认调用的是父类空参的构造器
	 * 		>建议：设计一个类时，尽量提供一个空参的构造器
	 */	
	
	private String choolName;
	int id; //子类与父类重名id
	
	public Student() {
		super();
		 //只是调用父类的构造器
	}
	public Student (String schoolName) {
		super("李雷",23);
		this.choolName = schoolName;
		System.out.println(schoolName);
	}
	public void show() {
		System.out.println(this.id );//this.id || id 
		System.out.println(super.id);
	}
}