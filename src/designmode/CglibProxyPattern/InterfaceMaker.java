package designmode.CglibProxyPattern;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class InterfaceMaker {

	public static void main(String[] args) {
		InterfaceMaker interfaceMaker     =new 	InterfaceMaker();
		
		//��ȡĳ����ķ������ɽӿڷ���
		interfaceMaker.add(TargetObject.class);
		Class<?> targetInterface = interfaceMaker.create();
		
		for(Method method : targetInterface.getMethods()){
            System.out.println(method.getName());
        }
		//�ӿڴ������ô���ӿڷ�������
        Object object = Enhancer.create(Object.class, new Class[]{targetInterface}, new MethodInterceptor()
        {
			@Override
			public Object intercept(Object obj, Method method, Object[] aobj, MethodProxy methodproxy)
					throws Throwable
			{
				return null;
			}	
        }
	}
}