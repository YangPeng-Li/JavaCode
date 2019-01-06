package oop;

/*
 * 1.格式：对于方法的形参：数据类型...形参名
 * 2.可变个数的形参方法与同名的方法之间构成重载
 * 3.可变个数的形参在调用是，个数从0开始，到无穷多个都可以
 * 4.使用可变多个形参的方法与方法的形参使用数组是一致的。
 * 5.一个方法种2个以上变量类型，可变个数的形参放在最后面
 * 6.在一个方法种最多声明一个可变形参（在类中形参类型相同的可以省略【处理方式一样】）
 * 实践应用计算器模拟 求多个数的加、减、乘、除
 * 
 */

public class TestArgs {
	public void sayHello (){
		System.out.println("Say  NO  Args");
		
	}
	public void SayHello(String str1)
	{
		System.out.println("Say Args"+str1);
	}
	
	//可变个数的形参的方法
	public void SayHello(String ... args )
	{
		for (int i=0;i<args.length;i++)
		{
			System.out.println(args[i]);
		}
	}
	
	public void SayHello(int i,String ...args)  {}
//	public void SayHello(String ...args ,int i) {}
	//可变个数的形参的方法
	public void SayHello11111(String[] str1)
	{
		for (int i=0;i<str1.length;i++)
		{
			System.out.println(str1[i]);
		}
	}
}
