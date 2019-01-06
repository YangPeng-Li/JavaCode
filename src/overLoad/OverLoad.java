package overLoad;



/**
 * 方法的重载（overload）
 * 要求：1.同一个类中，2.方法名相同，3.方法的参数列表不同（①参数类型②参数顺序）
 * 补充:方法的重载与方法的返回值没有关系
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
		//println 之间也能构成重载
	
	private void getSum () {
		
	}
}