package designmode.CglibProxyPattern;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * CGLIB是一个功能强大，高性能的代码生成包。它为没有实现接口的类提供代理，为JDK的动态代理提供了很好的补充。通常可以使用Java的动态代理创建代理，
 * 但当要代理的类没有实现接口或者为了更好的性能，CGLIB是一个好的选择。
 * 
 * @author Lyp
 * @date 2018年12月28日
 * @version 1.0
 *
 */
public class CglibProxy  implements MethodInterceptor  {

	   private Object target;

	    public CglibProxy(Object target) {
	        this.target = target;
	    }
	    /*
	     * 参数：Object为由CGLib动态生成的代理类实例，Method为上文中实体类所调用的被代理的方法引用，
	     * Object[]为参数值列表，MethodProxy为生成的代理类对方法的代理引用。
		 *	返回：从代理实例的方法调用返回的值。
		 *	其中，proxy.invokeSuper(obj,arg) 调用代理类实例上的proxy方法的父类方法（即实体类TargetObject中对应的方法）
		 *	在这个示例中，只在调用被代理类方法前后各打印了一句话，当然实际编程中可以是其它复杂逻辑。
	     * 
	     */

	    @Override
	    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
	        System.out.println("###   before invocation");
	        Object result = method.invoke(target, objects);
	        System.out.println("###   end invocation");
	        return result;
	    }
	
	    public static Object getProxy(Object target) {
	        Enhancer enhancer = new Enhancer();
	        // 设置需要代理的对象
	        enhancer.setSuperclass(target.getClass());
	        // 设置代理人
	        enhancer.setCallback(new CglibProxy(target));
	        return enhancer.create();
	    }
	
}
