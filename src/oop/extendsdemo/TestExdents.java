package oop.extendsdemo;

/*
 * oop ���������̳���
 * 1.ΪʲôҪ��Ƽ̳��ԣ�
 * 2.class A extends B ʵ����ļ̳�
 * 		���ࣺA ���ࣨ���ࡢSuperClass����B
 * 
 * 3.����̳и����Ժ󣬸��������������ԡ������������ȡ�����������name,age���ǲ�������ΪȨ�����ƣ�
 * 		��ȷ:��������˽�е����Ի򷽷�ʱ������ͬ�����Ի�ȡ����ֻ�����ڷ�װ�ԣ������޷�ֱ�ӵ���
 * 		�������ͨ���̳л�ȡ����Ľṹ���������Լ������Լ��Ľṹ
 * 
 * extends: �����ǶԸ��๦�ܵġ���չ�������಻�Ǹ�����Ӽ���
 * 
 * 4.Java�ļ̳�ֻ�ܵ��̳У�һ����ֻ�ܼ̳�һ���ࡣһ����������ж������
 * 5.����͸���ʱ��Ը���
 */
public class TestExdents {
	public static void main(String[] args) {
		Student s = new Student();
		s.eat();
		Student  s1 = new Student("PerkingUnivercity");
		System.out.println(s1.getName()+s1.getAge());
		
		Worker w = new Worker();
		w.eat();
	}
}
