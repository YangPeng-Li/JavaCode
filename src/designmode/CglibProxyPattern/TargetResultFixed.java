package designmode.CglibProxyPattern;

import net.sf.cglib.proxy.FixedValue;

/**
 * ��ʾ������������ֵ�����۱�������ķ�������ʲôֵ���ص����������ع̶�ֵ��
 *
 */
public class TargetResultFixed  implements FixedValue{
 
    /**
     * ����ʵ��FixedValue�ӿڣ�ͬʱ�����ص�ֵΪ999
     * (���ͣ�CallbackFilter�ж����ʹ��FixedValue�ͻص��ķ���ΪgetConcreteMethodFixedValue���÷�������ֵΪ����)��
     */
    @Override
    public Object loadObject() throws Exception {
        System.out.println("�������");
        Object obj = 999;
        return obj;
    }
 
}