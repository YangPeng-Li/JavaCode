package circulatioDemo;

public class forDemo {
	
	
	/**
	 * for ����ʼ�����ʽ;�������ʽ;������
	 * for ѭ���ڵ�һ�η���֮ǰҪ���г�ʼ������󣬽����������ԣ�������ÿ�η�����ʱ�����ĳ����ʽ�ġ�������(Stepping)forѭ������ʽ
	 * ��ʼ�����ʽ;�������ʽ;���� �������ÿգ�ÿ�η���Ǯ����Ҫ���Բ������ʽ��
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i=1,j=i+10;i<5;i++,j=i*2)
		{
			System.out.println("i="+i+" j="+j);
		}
	}

}
