package oop.moreStatus;


/*
 * �������������������̬��
 * 
 * 1.��̬��ָʲô����̬�ԣ��������Ϊһ������Ķ��ֱ���
 * 		1����������������д
 * 		2���������Ķ�̬(ֻ��Ӧ�ڷ���)
 * 2.��������̬ʹ�ã���Ҫ����ļ̳� ��������д����ķ���
 * 
 * 3.��Ա���з�Ϊ����״̬������״̬
 * 		���ڶ�̬����˵������ʱ��"�����"���������ñ�������Ϊ���������
 * 		����ʱ�������ұߡ�רע�����������ʵ�壬����Ķ���
 * 
 * 4.�������ԵĶ�̬�Բ��������ڶ�̬��
 * 
 */
public class TestPerson {

	public static void main(String[] args) {
		Person p = new Person();
		p.eat();
		p.walk();
		
		man m = new man();
		m.eat();
		m.walk();
		
		
		//�������Ķ�̬:���������ָ��������� ,���������ָ�������ã�
		
		Person p1 = new man(); //����ת��
		//���ⷽ���ĵ��ã�ͨ�����������ָ������ʵ�壬���÷���ʱ��ʵ��ִ�е�ʱ������д����ķ���
		p1.eat();
		p1.walk();
		System.out.println("�Ӹ������ж��Ե���ʾ��"+p1.id);
		
		man m1 = (man)p1; //����ת��
	//	p1.entainment();
		m1.entertainment();
		
		//instanceof
	
		if(p1 instanceof man)
		{
			man m11 = (man)p1;
			m11.entertainment();
		}
	}
	
	public void show (Person p) {
		Person p1  =  new man();
	}
	
}
