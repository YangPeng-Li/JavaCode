package oop;

/*
 * static ,��̬�ģ����������������ԡ����������߳�ʼ���飩���ڲ���
 * static �������ԣ��������
 * static
 * 
 */



/*�ؼ���Static
 * 1�������Ĵ���
 * 		��������෽��
 * 		�������(Singleton)ģʽ
 * 2.���main����
 * 3.���Ա�ĳ�ʼ����
 * 4.�ؼ��� final
 * 5.������(abstract class)
 * 	ģ�巽�����ģʽ(Template Method)
 * 6.�����׵ĳ��󣺽ӿڣ�Interface��
 * 		��������(FactoryMethod)�ʹ���ģʽ
 * 7.��ĳ�Ա֮�壺�ڲ���	
 */

/*
 * static ��������(�����)��
 * 1.���ഴ�������ж��󣬶�������һ������
 * 2.������һ������Դ����Խ����޸ģ��ᵼ����������Դ����Ե�һ�����á�  vsʵ������(��static���ε����ԣ������Լ��ĸ���)
 * 3.�������������ļ��ض����صģ����Ҷ�һ��
 * 4.��̬�ı�������ֱ��ͨ������.�����������ʽ������
 * 5.������ļ������ڶ������Ե��ж����Ժ󣬿��ԡ�����.����������ǡ���.��ʵ���������ǲ���
 * 6.����������ھ�̬����
 * 
 * 
 * 
 *
 *static���η������෽����
 *1.������ļ��ض����أ����ڴ���Ҳ�Ƕ�һ��
 *2.����ͨ������.�෽����
 *3.�ڲ����Ե��þ�̬�����Ժ;�̬�ķ����������ܵ��÷Ǿ�̬�����Ժͷ���
 *	��֮���ԷǾ�̬�Ŀ��Ե��þ�̬������
 *
 *��̬�ķ��������ǲ�������this����super
 *
 *ע����̬�Ľṹ��Static�����ԡ�����������顢�ڲ��ࣩ����������Ҫ���ڷǾ�̬��ͬʱ��������
 */




public class StaticKey {
	//ʵ�����������Ŷ���Ĵ����������صģ�
	String name;
	int age;
	//�����
	static String nation;
	public StaticKey(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}



class postMan{
	
	String name;
	int age;
	static String nation;
	public  void show() {
		
	}
	
	public static void show1() {
		info();
	System.out.println("nation"+nation); //nation���������ں�staic show1��ͬ
	//System.out.println("age:"+this.age); //
	System.out.println();
	}
	
	public static void info() {
		System.out.println("���Ǿ�̬����");
	}
}
