package designmode.CglibProxyPattern;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;


/**
 * 	����Enhancer����CGLib�е�һ���ֽ�����ǿ���������Է���Ķ�����Ҫ������������չ���Ժ�ᾭ����������
 *	���Ƚ���������TargetObject���óɸ��࣬Ȼ������������TargetInterceptor�����ִ��enhancer.create()��̬����һ�������࣬����Objectǿ��ת�ͳɸ�����TargetObject��
 *	����ڴ������ϵ��÷�����
 * 
 * @author Lyp
 * @date 2018��12��28��
 * @version 1.0
 *
 */
public class TestCglib {
	public static void main(String args[]) {
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        CallbackFilter callbackFilter = new TargetMethodCallbackFilter();
        
        /**
         * (1)callback1������������
           (2)NoOp.INSTANCE�����NoOp��ʾno operator����ʲô����Ҳ������������ֱ�ӵ��ñ�����ķ������������ء�
           (3)FixedValue����ʾ������������ֵ�����۱�������ķ�������ʲôֵ���ص����������ع̶�ֵ��
         */
        Callback noopCb=NoOp.INSTANCE;
        Callback callback1=new TargetInterceptor();
        Callback fixedValue=new TargetResultFixed();
        Callback[] cbarray=new Callback[]{callback1,noopCb,fixedValue};
        //enhancer.setCallback(new TargetInterceptor());
        enhancer.setCallbacks(cbarray);
        enhancer.setCallbackFilter(callbackFilter);
        TargetObject targetObject2=(TargetObject)enhancer.create();
        System.out.println(targetObject2);
        System.out.println(targetObject2.method1("mmm1"));
        System.out.println(targetObject2.method2(100));
        System.out.println(targetObject2.method3(100));
        System.out.println(targetObject2.method3(200));
    }
}