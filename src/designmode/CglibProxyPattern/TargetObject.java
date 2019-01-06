package designmode.CglibProxyPattern;

/**
 * Cglib ��̬��������Դ������, ��̬����һ������, Ȼ�����า�Ǵ������еķ���, �����private����final�����εķ���,�򲻻ᱻ��д��
 * CGLIB��һ������ǿ�󣬸����ܵĴ������ɰ�����Ϊû��ʵ�ֽӿڵ����ṩ����ΪJDK�Ķ�̬�����ṩ�˺ܺõĲ��䡣
 * ͨ������ʹ��Java�Ķ�̬��������������Ҫ�������û��ʵ�ֽӿڻ���Ϊ�˸��õ����ܣ�CGLIB��һ���õ�ѡ��
 * CGLIB��Ϊһ����Դ��Ŀ��������й���github����ַΪ��https://github.com/cglib/cglib
*/
/*
 * ��������
 */
public class TargetObject {
    public String method1(String paramName) {
        return paramName;
    }
 
    public int method2(int count) {
        return count;
    }
 
    public int method3(int count) {
        return count;
    }
 
    @Override
    public String toString() {
        return "TargetObject []"+ getClass();
    }
}
