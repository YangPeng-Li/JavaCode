package oop;

/*
 * 1.��ʽ�����ڷ������βΣ���������...�β���
 * 2.�ɱ�������βη�����ͬ���ķ���֮�乹������
 * 3.�ɱ�������β��ڵ����ǣ�������0��ʼ����������������
 * 4.ʹ�ÿɱ����βεķ����뷽�����β�ʹ��������һ�µġ�
 * 5.һ��������2�����ϱ������ͣ��ɱ�������βη��������
 * 6.��һ���������������һ���ɱ��βΣ��������β�������ͬ�Ŀ���ʡ�ԡ�����ʽһ������
 * ʵ��Ӧ�ü�����ģ�� �������ļӡ������ˡ���
 * 
 */

public class TestArgs {
	public void sayHello (){
		System.out.println("Say  NO  Args");
		
	}
	public void SayHello(String str1)
	{
		System.out.println("Say Args"+str1);
	}
	
	//�ɱ�������βεķ���
	public void SayHello(String ... args )
	{
		for (int i=0;i<args.length;i++)
		{
			System.out.println(args[i]);
		}
	}
	
	public void SayHello(int i,String ...args)  {}
//	public void SayHello(String ...args ,int i) {}
	//�ɱ�������βεķ���
	public void SayHello11111(String[] str1)
	{
		for (int i=0;i<str1.length;i++)
		{
			System.out.println(str1[i]);
		}
	}
}
