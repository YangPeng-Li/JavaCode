package designmode.CglibProxyPattern;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

/**
 * 回调过滤器CallbackFilter

	一、作用
	在CGLib回调时可以设置对不同方法执行不同的回调逻辑，或者根本不执行回调。
	在JDK动态代理中并没有类似的功能，对InvocationHandler接口方法的调用对代理类内的所有方法都有效。
	定义实现过滤器CallbackFilter接口的类：
 * 
 * @author Lyp
 * @date 2018年12月28日
 * @version 1.0
 *
 */
public class TargetMethodCallbackFilter implements CallbackFilter {
 
    /**
     * 过滤方法
     * 返回的值为数字，代表了Callback数组中的索引位置，要到用的Callback
     */
    @Override
    public int accept(Method method) {
        if(method.getName().equals("method1")){
            System.out.println("filter method1 ==0");
            return 0;
        }
        if(method.getName().equals("method2")){
            System.out.println("filter method2 ==1");
            return 1;
        }
        if(method.getName().equals("method3")){
            System.out.println("filter method3 ==2");
            return 2;
        }
        return 0;
    }

}
