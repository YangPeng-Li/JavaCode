package circulatioDemo;

import org.junit.Test;

/**
 * 在任何循环语句的主体部分，
 * 亦可用 break 和 continue 控制循环的流程。
 * 其中， break 用于强行退出循环，不执行循环中剩余的语句。
 * 而 continue 则停止执行当前的反复，然后退回循环起始和，开始新的反复
 * 
 * @author Lyp
 * @date 2018年12月27日
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
