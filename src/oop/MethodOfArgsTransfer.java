package oop;

public class MethodOfArgsTransfer {
/*方法的参数传递
 * 1.方法，必须含有参数：
 * 形参：方法声明时的参数
 * 实参：方法调用时实际传递给形参的参数值
 * 
 * 2.规则:Java里方法的参数传递只有一种：值传递。
 *		【将实际参数值的副本（复制品）传入方法内，而参数本身不受影响】
 *		1）形参是基本数据类型，将实参的值传递给形参的
 *		2）形参是引用数据类型,将形参的引用类型变量的值（对应的对空间对象实体的首地址）传递给形参的引用类型变量
 *
 *
 *
 *
 */
	public static void main(String[] args) {
		MethodOfArgsTransfer tt = new MethodOfArgsTransfer();//存在于栈空间先进后出 
		int i = 5; 
		int j = 10;
		System.out.println("i："+i+"j:"+j);
		tt.swap(i, j);
		System.out.println("i："+i+"j:"+j);
	}
	
	public  void swap(int i, int j) {

		int temp = i;
		i = j;
		j = temp;
		System.out.println("i："+i+"j:"+j);
	}
	

	
}
