package designmode.DynamicProxyPattern;

import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		
		//���Ƕ���
		Subject realSubject    = new RealSubject();
		MyInvocationHandler  myInvocationHandle = new MyInvocationHandler(realSubject);
		
		 Subject proxyClass = (Subject)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class []{Subject.class}, myInvocationHandle);
		
		//�������
		 proxyClass.sellBooks();
		 proxyClass.speak();
		
	}
}
