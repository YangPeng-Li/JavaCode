package circulatioDemo;

public class forDemo {
	
	
	/**
	 * for （初始化表达式;布尔表达式;步进）
	 * for 循环在第一次反复之前要进行初始化。随后，进行条件测试，而且在每次反复的时候进行某种形式的“步进”(Stepping)for循环的形式
	 * 初始化表达式;布尔表达式;步进 都可以置空，每次反复钱，都要测试布尔表达式。
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i=1,j=i+10;i<5;i++,j=i*2)
		{
			System.out.println("i="+i+" j="+j);
		}
	}

}
