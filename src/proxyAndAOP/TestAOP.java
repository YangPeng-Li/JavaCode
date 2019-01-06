package proxyAndAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
	void info();
	 
	void fly();
}

//��������
class SuperMan implements Human {
	public void info() {
		System.out.println("���ǳ��ˣ�����˭��");
	}

	@Override
	public void fly() {
		System.out.println("I believe I can fly ");
	}
}

class HumanUtil {
	public void method1() {
		System.out.println("=====������=====");
	}
	
	public void method2() {
		System.out.println("=====������=====");
	}
}






class MyInvocationHandler implements InvocationHandler{

	//���������������
	Object obj;
	
	public void setObject (Object obj) {
		this.obj = obj;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
	HumanUtil h = new HumanUtil();
	h.method1();
	Object returnVal = 	method.invoke(obj, args);
	h.method2();	
	return returnVal; //���� info() fly() 
	}
	
}


class MyProxy{
//��̬�Ĵ���һ��������Ķ���
	public static Object getProxyInstance(Object obj)
	{
		MyInvocationHandler handler = new MyInvocationHandler();
		handler.setObject(obj);
	
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
		
	}
}



public class TestAOP {
	
	public static void main(String[] args) {
		SuperMan man = new SuperMan();//����һ������������
	 Object obj = MyProxy.getProxyInstance(man);//����һ�����������
	 Human hu = (Human)obj; //�ӿڷ���
	 hu.info();//ͨ��������Ķ��������д�ĳ��󷽷�
	 System.out.println();
	 hu.fly();
	}
	
	
}