package designmode.CglibProxyPattern;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TargetInterceptor implements MethodInterceptor{
 
    /**
     * ��д���������ڷ���ǰ�ͷ��������ҵ��
     * Object objΪĿ�����
     * Method methodΪĿ�귽��
     * Object[] params Ϊ������
     * MethodProxy proxy CGlib�����������
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] params,
            MethodProxy proxy) throws Throwable {
        System.out.println("����ǰ");
        Object result = proxy.invokeSuper(obj, params);
        System.out.println(" ���ú�"+result);
        return result;
    }
}