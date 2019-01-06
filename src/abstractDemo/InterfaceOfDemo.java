package abstractDemo;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.FileObject;
import javax.tools.JavaFileManager.Location;
import javax.tools.JavaFileObject;

/*
 * 接口
 * 
 * 特殊的抽象类这种抽象类中只包含常量和方法的定义，而没有变量和方法的实现
 * 
 * 接口（Inteface）是与类并行是一个概念
 * 1.可以看成一个特殊的抽象类，是常量与抽象方法的一个集合,不能包含变量、一般的方法
 * 2.接口是没有构造器的
 * 3.接口定义的就是一种功能，此功能可以被类所实现（implements）
 * 4.实现接口的类，必须要重写其中的所有的抽象方法，方可实例化，若没有重写所有的抽象方法，
 * 		则此类仍为一个抽象类
 * 5.类可以实现多个接口 --- java中的继承是单继承，而且可以是多继承
 * 6.接口和接口之间 也是继承关系
 * 	5，6描述的类和接口之间的特点
 */

public class InterfaceOfDemo {
	
	public static void main(String[] args) {
		System.out.println(AA.i);
		//AA.i=12;
		System.out.println(AA.i);
		
		
	}
}


interface AA{
	//常量：所有的常量都用public static final来修饰
	int i =12;
	public static  boolean  Flag =false;
	//抽象方法
	void method1();
	void method2();
	
}


abstract class BB implements AA{
	
}

class CC implements AA{

	@Override
	public void method1() {
		
	}

	@Override
	public void method2() {
		
	}
	
}
class DD  extends BB  implements AA {

	@Override
	public void method1() {
		// TODO Auto-generated method stub
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
	}
	
}
 interface  OO {}
 	
 	//
	interface JJ extends AA,OO {
		
	}

	
	
	