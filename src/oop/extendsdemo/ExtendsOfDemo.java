package oop.extendsdemo;

public class ExtendsOfDemo  {

}
class Student extends Person {
	/*
	 * super���������������Է���������
	 * 1���������븸����ͬ������ʱ������ͨ��super.������ʽ�ĵ��� 
	 * 		��������ͬ������ this.����
	 * 2����������д���෽�� �������ģ�super.������()
	 * 
	 * 3)super���ι�������ͨ��������ʹ��super(�β��б�)����ʾ�ĵ���ָ���Ĺ�����
	 * 		>�ڹ������ڲ�����super���β��б�����������������
	 * 		>super ��this ֻ����һ������
	 * 		>���������в���ʾ�ĵ���this() ��super() Ĭ�ϵ��õ��Ǹ���ղεĹ�����
	 * 		>���飺���һ����ʱ�������ṩһ���ղεĹ�����
	 */	
	
	private String choolName;
	int id; //�����븸������id
	
	public Student() {
		super();
		 //ֻ�ǵ��ø���Ĺ�����
	}
	public Student (String schoolName) {
		super("����",23);
		this.choolName = schoolName;
		System.out.println(schoolName);
	}
	public void show() {
		System.out.println(this.id );//this.id || id 
		System.out.println(super.id);
	}
}