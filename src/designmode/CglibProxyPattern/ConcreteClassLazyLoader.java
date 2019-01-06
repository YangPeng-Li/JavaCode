package designmode.CglibProxyPattern;

import net.sf.cglib.proxy.LazyLoader;

public class ConcreteClassLazyLoader implements LazyLoader {

	 /**
     * ����Ҫ�ӳټ��صĶ�����Ӵ����ڻ�ȡ�ö�������ʱ��ͨ��������ص��������ж����ʼ����
     * �ڲ���Ҫ���ظö���ʱ��ֻҪ��ȥ��ȡ�ö��������ԣ��ö���Ͳ��ᱻ��ʼ���ˣ���CGLib��ʵ����ֻҪȥ���ʸö��������Ե�getter������
     * �ͻ��Զ�����������ص�����
     */
    @Override
    public Object loadObject() throws Exception {
        System.out.println("before lazyLoader...");
        PropertyBean propertyBean = new PropertyBean();
        propertyBean.setKey("zghw");
        propertyBean.setValue(new TargetObject());
        System.out.println("after lazyLoader...");
        return propertyBean;
    }
 
}
