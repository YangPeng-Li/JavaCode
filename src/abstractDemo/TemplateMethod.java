package abstractDemo;

/*
 * 模板方法设计模式（TemplateMethod）
 * 
 * 抽象类的体现就是一种模板设计，
 * 抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展，改造但
 * 子类总体上会保留抽象类的行为方式
 * 
 * 
 * 解决的问题：
 * 	1）当功能内部一部分实现是确定，
 * 	     一部分实现是不确定的这时可以把不确定的部分暴露出去，让子类去实现
 * 	2）编写一个抽象父类，父类提供多个子类的通用方法，并把一个或多个方法
 * 	     留给其子类实现，就是一种模板模式
 * 
 */

public class TemplateMethod {
	public static void main(String[] args) {
	new SubTemplate().spendTime();
}
	
	
}

abstract class Template {
	
	public  abstract void code();
	public void spendTime() {
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		System.out.println("花费时间："+(end-start));
	}
	
	
}
class SubTemplate extends Template{
	
	public  void code() {
		boolean flag =false;
		for (int i=2;i<100000;i++)
		{
			for(int j=2;j<Math.sqrt(i);j++) //开方
			{
				if(i%j == 0)
				{
					flag= true;
					break;
				}
			}
			if (!flag ) {
				System.out.println(i);
			}
			flag = false;
		}
	}
}
