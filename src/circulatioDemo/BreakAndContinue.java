package circulatioDemo;

import org.junit.Test;

/**
 * ���κ�ѭ���������岿�֣�
 * ����� break �� continue ����ѭ�������̡�
 * ���У� break ����ǿ���˳�ѭ������ִ��ѭ����ʣ�����䡣
 * �� continue ��ִֹͣ�е�ǰ�ķ�����Ȼ���˻�ѭ����ʼ�ͣ���ʼ�µķ���
 * 
 * @author Lyp
 * @date 2018��12��27��
 * @version 1.0
 *
 */
public class BreakAndContinue {
	
	public static void main(String[] args) {
		int i = 0;
		outer:
			for (i=0;true;)
			{
				inner:
					for (;i<10;i++)
					{
						prt("i= "+i);
						if(i ==2)
						{
							prt("continue");
							
							continue;
							
						}
						
						if(i ==3)
						{
							prt("break");
							i++;
							break;
							
						}
						if(i == 7)
						{
							prt("continue outer");
							i++;
							continue outer;
						}
						
						if(i ==8)
						{
							prt("break outer");
							break outer;
						}
						
						for (int k = 0;k<5;k++)
						{
							if(k==3)
							{
								prt("continue inner===");
								continue inner;
							}
						}
							
					}
			}
	}
	static void prt (String s)
	{
		System.out.println(s);
	}
	
	
	
	
}
