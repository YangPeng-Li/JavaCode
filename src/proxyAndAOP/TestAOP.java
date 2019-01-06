package proxyAndAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
	void info();
	 
	void fly();
}

//被代理类
class SuperMan implements Human {
	public void info() {
		System.out.println("我是超人！我怕谁！");
	}

	@Override
	public void fly() {
		System.out.println("I believe I can fly ");
	}
}

class HumanUtil {
	public void method1() {
		System.out.println("=====方法①=====");
	}
	
	public void method2() {
		System.out.println("=====方法②=====");
	}
}






class MyInvocationHandler implements InvocationHandler{

	//被代理对象的声明
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
	return returnVal; //返回 info() fly() 
	}
	
}


class MyProxy{
//动态的创建一个代理类的对象
	public static Object getProxyInstance(Object obj)
	{
		MyInvocationHandler handler = new MyInvocationHandler();
		handler.setObject(obj);
	
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
		
	}
}



public class TestAOP {
	
	public static void main(String[] args) {
		SuperMan man = new SuperMan();//创建一个被代理对象
	 Object obj = MyProxy.getProxyInstance(man);//返回一个代理类对象
	 Human hu = (Human)obj; //接口方法
	 hu.info();//通过代理类的对象调用重写的抽象方法
	 System.out.println();
	 hu.fly();
	}
	
	
}
