package annotationDemo;

import java.util.ArrayList;
import java.util.List;

/*
 * Annotation��ʵ���Ǵ���������ǣ���Щ��ǿ����ڱ��룬����أ�����ʱ����ȡ����ִ����Ӧ�Ĵ���
 * ͨ��ʹ��Annotation������Ա�����ڲ��ı�ԭ���߼�������£���Դ�ļ���
 * Ƕ��һЩ������Ϣ
 * 
 * 
 * Annotation ���������η�һ����ʹ�ã������������ΰ����࣬������������
 * ��Ա�������������ֲ���������������ЩЩ��Ϣ��������Annotation
 * �ܱ�����Ϊ����Ԫ�أ��ࡢ��������Ա����������Ԫ����
 * 
 * 
 * 
 * 1.����ע������
 * @Override���޶���д
 * @Deprecated ����ʾ����Ԫ���ѹ�ʱ
 * @SuppressWarnings ���Ʊ���������
 * 2.����Զ���һ��ע��
 * 3.Ԫע��
 * 
 */
public class Annotation {
	
	public static void main(String[] args) {
		Person p = new Student();
		p.walk();
		p.eat();
		@SuppressWarnings({"rawtypes","unused"})
		List list =  new ArrayList();
	}
}

class Person{
	String name;
	int age;
	@Deprecated
	public void eat()
	{
		System.out.println("�Է�");
	}
	public void walk() {
		System.out.println("��·");
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
class Student extends Person{

	@Override
	public void walk() {
		System.out.println("ѧ����·");
	}
	
	public void eat() {
		System.out.println("ѧ���Է�");
	}
	
	
}