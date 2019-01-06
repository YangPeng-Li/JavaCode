package designmode.DynamicProxyPattern;

import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		
		//真是对象
		Subject realSubject    = new RealSubject();
		MyInvocationHandler  myInvocationHandle = new MyInvocationHandler(realSubject);
		
		 Subject proxyClass = (Subject)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class []{Subject.class}, myInvocationHandle);
		
		//代理对象
		 proxyClass.sellBooks();
		 proxyClass.speak();
		
	}
}
