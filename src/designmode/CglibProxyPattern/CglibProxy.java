package designmode.CglibProxyPattern;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * CGLIB��һ������ǿ�󣬸����ܵĴ������ɰ�����Ϊû��ʵ�ֽӿڵ����ṩ����ΪJDK�Ķ�̬�����ṩ�˺ܺõĲ��䡣ͨ������ʹ��Java�Ķ�̬����������
 * ����Ҫ�������û��ʵ�ֽӿڻ���Ϊ�˸��õ����ܣ�CGLIB��һ���õ�ѡ��
 * 
 * @author Lyp
 * @date 2018��12��28��
 * @version 1.0
 *
 */
public class CglibProxy  implements MethodInterceptor  {

	   private Object target;

	    public CglibProxy(Object target) {
	        this.target = target;
	    }
	    /*
	     * ������ObjectΪ��CGLib��̬���ɵĴ�����ʵ����MethodΪ������ʵ���������õı�����ķ������ã�
	     * Object[]Ϊ����ֵ�б�MethodProxyΪ���ɵĴ�����Է����Ĵ������á�
		 *	���أ��Ӵ���ʵ���ķ������÷��ص�ֵ��
		 *	���У�proxy.invokeSuper(obj,arg) ���ô�����ʵ���ϵ�proxy�����ĸ��෽������ʵ����TargetObject�ж�Ӧ�ķ�����
		 *	�����ʾ���У�ֻ�ڵ��ñ������෽��ǰ�����ӡ��һ�仰����Ȼʵ�ʱ���п��������������߼���
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
	        // ������Ҫ����Ķ���
	        enhancer.setSuperclass(target.getClass());
	        // ���ô�����
	        enhancer.setCallback(new CglibProxy(target));
	        return enhancer.create();
	    }
	
}
