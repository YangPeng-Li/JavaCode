package singgleMode;


//懒汉式
//存在线程安全问题
public class SingletonTest {
	public static void main(String[] args) {
		
		Singleton1 s1=  Singleton1.getInstance();
		Singleton1 s2 =  Singleton1.getInstance();
		System.out.println(s1 == s2);
		
	}
	
	
}
class Singleton1{
		
		//1.私有化构造器
		private Singleton1() {}
		//2.私有化属性（创建单实例）【在类的内部创建单个实例】
		private static Singleton1 instance =  null;
		
		//3.私有化对象，通过公共的方法调用
		public static Singleton1 getInstance() {
			if(instance == null) {
				instance = new Singleton1();
			}
			return instance;
		}  
}