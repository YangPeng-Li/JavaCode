package designmode.CglibProxyPattern;

import net.sf.cglib.proxy.Enhancer;

public class LazyBean {

	 private String name;
	    private int age;
	    private PropertyBean propertyBean;
	    private PropertyBean propertyBeanDispatcher;
	 
	    public LazyBean(String name, int age) {
	        System.out.println("lazy bean init");
	        this.name = name;
	        this.age = age;
	        this.propertyBean = createPropertyBean();
	        this.propertyBeanDispatcher = createPropertyBeanDispatcher();
	    }

		private PropertyBean createPropertyBeanDispatcher() {
			Enhancer enhancer = new Enhancer();
	        enhancer.setSuperclass(PropertyBean.class);
	        PropertyBean pb = (PropertyBean) enhancer.create(PropertyBean.class,
	                new ConcreteClassDispatcher());
	        return pb;
		}

		private PropertyBean createPropertyBean() {
			  /**
	         * ʹ��cglib���������� ����Ҫ�ӳټ��صĶ�����Ӵ����ڻ�ȡ�ö�������ʱ��ͨ��������ص��������ж����ʼ����
	         * �ڲ���Ҫ���ظö���ʱ��ֻҪ��ȥ��ȡ�ö��������ԣ��ö���Ͳ��ᱻ��ʼ���ˣ���CGLib��ʵ����ֻҪȥ���ʸö��������Ե�getter������
	         * �ͻ��Զ�����������ص�����
	         */
	        Enhancer enhancer = new Enhancer();
	        enhancer.setSuperclass(PropertyBean.class);
	        PropertyBean pb = (PropertyBean) enhancer.create(PropertyBean.class,
	                new ConcreteClassLazyLoader());
	        return pb;
		}
}
