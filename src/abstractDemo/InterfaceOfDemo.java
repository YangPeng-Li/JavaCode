package abstractDemo;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.FileObject;
import javax.tools.JavaFileManager.Location;
import javax.tools.JavaFileObject;

/*
 * �ӿ�
 * 
 * ����ĳ��������ֳ�������ֻ���������ͷ����Ķ��壬��û�б����ͷ�����ʵ��
 * 
 * �ӿڣ�Inteface�������ಢ����һ������
 * 1.���Կ���һ������ĳ����࣬�ǳ�������󷽷���һ������,���ܰ���������һ��ķ���
 * 2.�ӿ���û�й�������
 * 3.�ӿڶ���ľ���һ�ֹ��ܣ��˹��ܿ��Ա�����ʵ�֣�implements��
 * 4.ʵ�ֽӿڵ��࣬����Ҫ��д���е����еĳ��󷽷�������ʵ��������û����д���еĳ��󷽷���
 * 		�������Ϊһ��������
 * 5.�����ʵ�ֶ���ӿ� --- java�еļ̳��ǵ��̳У����ҿ����Ƕ�̳�
 * 6.�ӿںͽӿ�֮�� Ҳ�Ǽ̳й�ϵ
 * 	5��6��������ͽӿ�֮����ص�
 */

public class InterfaceOfDemo {
	
	public static void main(String[] args) {
		System.out.println(AA.i);
		//AA.i=12;
		System.out.println(AA.i);
		
		
	}
}


interface AA{
	//���������еĳ�������public static final������
	int i =12;
	public static  boolean  Flag =false;
	//���󷽷�
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

	
	
	