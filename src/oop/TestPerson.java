package oop;


/*
 * 1.�������ı��רע��������
 * 2.�����ʵ���Ͼ��������ĳ�Ա
 * 3.��������ĳ�Ա�����ԣ�field����Ա������ & ������Method��
 * 
 * This��
 * 1.���������������ԡ����ط���������
 * 2.this���Ϊ��ǰ�����ǰ���ڴ����Ķ���
 * 3.�����ڹ�������ͨ����this(�β�)�ķ�ʽ��ʾ�ĵ��ñ������������ص�ָ���Ĺ�����
 * 			1).Ҫ��������������������
 * 			2)(n�����������ֻ�ܵ���n-1������)
 */


public class TestPerson {

	//�࣬����� ---->����ͼֽ
	class Person {
		//field ����
		String name;
		int age;
		boolean sex;
		public Person () {
			
		}
		public Person(int age) {
			this.age = age;
		}
		public Person(String name) {
			System.out.println("����Person�����β�Ϊname�Ĺ�����");
			this.name = name; 
		}
		/*this.name��ʾ���ڴ����Ķ���
		name �β� */
		public Person (int age,String name) {
		//this():����������ʾ�ĵ��õ�ǰ������ص�ָ���Ĺ�����
		//this.name= name;
			this(age);  //������ڵ�һ��
			this.age =age;
			System.out.println("����Person�����β�Ϊname��age�Ĺ�����");
		}
		
		//2.����
		public void eat(){
			System.out.println("Person eat");
		}
		public void sleep() {
			System.out.println("Person sleep");
		}
		
		public String getName() {
			return name;
		}
		public void SetName(String n) {
			name = n;
		}
		
		public void info() { 
			eat();
			sleep();
			System.out.println("name"+name+"age"+age+"sex"+sex);
		}
	}
	
	
}
