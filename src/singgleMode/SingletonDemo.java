package singgleMode;


/*������Singleton�����ģʽ
 * ���ģʽ:���ڴ�����ʵ�����ܽ�����ۻ�֮����ѡ�Ĵ���ṹ����̷���Լ���������˼����ʽ��
 * 
 * �������ģʽ��
 * 1.�������һ����ֻ�ܹ�����һ������
 * 
 *
 */

//����ʽ
public class SingletonDemo {
	
	public static void main(String[] args) {
		Singleton s1 = 	Singleton.getInstance();
		Singleton s2 = 	Singleton.getInstance();
		System.out.println(s1 == s2);
	}
	
}
class Singleton{
	//1.˽�л�������,ʹ��������ⲿ���ܵ��ù�����
	private Singleton(){}
	//2.������ڲ�����һ�����ʵ��
	private static Singleton instance = new Singleton();
	//3.˽�л�����ͨ�������ķ�������
	//4�˹�������ֻ��ͨ���������ã��������Ϊ�Gstatic�ģ�ͬʱ���ʵ��Ҳ����Ϊstatic������
	public static Singleton getInstance() {
		return instance;
	}
}