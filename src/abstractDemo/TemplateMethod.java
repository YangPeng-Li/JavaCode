package abstractDemo;

/*
 * ģ�巽�����ģʽ��TemplateMethod��
 * 
 * ����������־���һ��ģ����ƣ�
 * ��������Ϊ��������ͨ��ģ�壬�����ڳ�����Ļ����Ͻ�����չ�����쵫
 * ���������ϻᱣ�����������Ϊ��ʽ
 * 
 * 
 * ��������⣺
 * 	1���������ڲ�һ����ʵ����ȷ����
 * 	     һ����ʵ���ǲ�ȷ������ʱ���԰Ѳ�ȷ���Ĳ��ֱ�¶��ȥ��������ȥʵ��
 * 	2����дһ�������࣬�����ṩ��������ͨ�÷���������һ����������
 * 	     ����������ʵ�֣�����һ��ģ��ģʽ
 * 
 */

public class TemplateMethod {
	public static void main(String[] args) {
	new SubTemplate().spendTime();
}
	
	
}

abstract class Template {
	
	public  abstract void code();
	public void spendTime() {
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		System.out.println("����ʱ�䣺"+(end-start));
	}
	
	
}
class SubTemplate extends Template{
	
	public  void code() {
		boolean flag =false;
		for (int i=2;i<100000;i++)
		{
			for(int j=2;j<Math.sqrt(i);j++) //����
			{
				if(i%j == 0)
				{
					flag= true;
					break;
				}
			}
			if (!flag ) {
				System.out.println(i);
			}
			flag = false;
		}
	}
}
