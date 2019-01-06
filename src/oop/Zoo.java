package oop;

public class Zoo {
	//java 类及类的成员=======>（如何使用java类）=====>java类的实例化，即创建类的对象
		/*一、面向对象落地实现
		 * 1.设计类：并设计类的成员（成员变量&成员方法）
		 * 2.通过类：来创建类的对象（也称作类的实例化）
		 * 3.通过“对象.属性”。属性或“对象.方法（）”完成
		 *
		 *二、创建的多个对象、彼此拥有一套属性
		 *
		 *三、类的属性与成员变量
		 *	成员变量 	vs	 局部变量
		 *	相同点: 	1.遵循变量声明的格式，数据类型 变量名  = 初始化值(成员变量默认值)
		 *			2.都有作用域
		 *	
		 *	不同点：  	1.声明位置不同：成员变量(属性,方法)：声明在类里 ，方法外  
		 *						局部变量： 声明在方法内(形参)，方法的形参部分，代码块内
		 *			2.成员变量的修饰符四个：public private  protected 缺省
		 *			      局部变量 没有修饰符：与所在方法的修饰符一样
		 *			
		 *			3.初始化值：一定会有初始化值
		 *			byte short int long  =====>   	0
		 *			float double		 =====>		0.0
		 *			char				 =====>		空格
		 *			boolean				 =====>		false
		 *			引用类型变量  			 =====> 	null
		 *			
		 *			局部变量要显示的赋值 （没有默认的值）
		 *			
		 *			4.二者在内存中存放的位置不同 ：成员变量存放在堆空间，局部变量存放在栈空间
		 *
		 *	总结：关于变量的分类
		 *					1）数据类型分类 8种
		 *					2）按照声明的位置不同  ，成员变量&局部变量
		 *四：类的方法：提供某种功能的实现
		 *		1）实例 ：public void eat(){ 【方法体】}
		 *			   public String getName(){}
		 *			       格式：权限修饰符   返回值类型 [void无返回值/具体返回值] 方法名()
		 *		2)关于返回值类型：void：表明方法不返回
		 *					有返回值，在方法的最后有返回值 （return 后面，不可以再声明语句）
		 *		3)方法内可以调用本类的其他方法/属性，但是不可以再方法内定义新的方法	
		 */			
	public static void main(String[] args) {
		//基本数据类型的声明：数据类型变量名 = 初始化值；
		int i =10;
		//类的实例化：如下的a1就是一个实实在在的对象
		Animal a1 = new Animal();  // new出来的是一个实体（name,age）  
		System.out.println("name"+a1.name +"age"+ a1.age);
		//通过对象调用属性
		a1.name= "Cat";
		a1.age = 2;
		System.out.println("name"+a1.name +"age"+ a1.age);
		//对象调用方法
		a1.eat();
		a1.sleep();
		//我昨天问你借了1000，昨天的我不是今天的我
	}
}
class Animal{
	//1.属性
	String name;   //却省的 
	int age;
	public void eat () 
	{
		System.out.println();
	}
	public void sleep() 
	{
		System.out.println();
	}
	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		name = n;
	}
	public void  addAge() {
		int i = 2;
		age +=i; //age=age+2;
	}
}
