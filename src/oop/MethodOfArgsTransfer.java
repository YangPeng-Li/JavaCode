package oop;

public class MethodOfArgsTransfer {
/*�����Ĳ�������
 * 1.���������뺬�в�����
 * �βΣ���������ʱ�Ĳ���
 * ʵ�Σ���������ʱʵ�ʴ��ݸ��βεĲ���ֵ
 * 
 * 2.����:Java�﷽���Ĳ�������ֻ��һ�֣�ֵ���ݡ�
 *		����ʵ�ʲ���ֵ�ĸ���������Ʒ�����뷽���ڣ�������������Ӱ�졿
 *		1���β��ǻ����������ͣ���ʵ�ε�ֵ���ݸ��βε�
 *		2���β���������������,���βε��������ͱ�����ֵ����Ӧ�ĶԿռ����ʵ����׵�ַ�����ݸ��βε��������ͱ���
 *
 *
 *
 *
 */
	public static void main(String[] args) {
		MethodOfArgsTransfer tt = new MethodOfArgsTransfer();//������ջ�ռ��Ƚ���� 
		int i = 5; 
		int j = 10;
		System.out.println("i��"+i+"j:"+j);
		tt.swap(i, j);
		System.out.println("i��"+i+"j:"+j);
	}
	
	public  void swap(int i, int j) {

		int temp = i;
		i = j;
		j = temp;
		System.out.println("i��"+i+"j:"+j);
	}
	

	
}
