package overLoad;



/**
 * ���������أ�overload��
 * Ҫ��1.ͬһ�����У�2.��������ͬ��3.�����Ĳ����б�ͬ���ٲ������͢ڲ���˳��
 * ����:�����������뷽���ķ���ֵû�й�ϵ
 */
public class OverLoad {

}
class testOverLoad{
	
	public int getSum (int i,int j) {
		return i+j;
	}
	
	
	public int getSum(int i,int j,int k) {
		return i+j+k;
	}
	
	
	public double getSum (double i,double j) {
		return i+j;
	}
	
	public void getSum (double d1,double d2,double d3) {
		System.out.println(d1+d2+d3);
	}
		//println ֮��Ҳ�ܹ�������
	
	private void getSum () {
		
	}
}