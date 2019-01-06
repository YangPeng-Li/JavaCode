package singgleMode;


/*单例（Singleton）设计模式
 * 设计模式:是在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。
 * 
 * 单例设计模式：
 * 1.解决问题一个类只能够创建一个对象
 * 
 *
 */

//饿汉式
public class SingletonDemo {
	
	public static void main(String[] args) {
		Singleton s1 = 	Singleton.getInstance();
		Singleton s2 = 	Singleton.getInstance();
		System.out.println(s1 == s2);
	}
	
}
class Singleton{
	//1.私有化构造器,使得在类的外部不能调用构造器
	private Singleton(){}
	//2.在类的内部创建一个类的实例
	private static Singleton instance = new Singleton();
	//3.私有化对象，通过公共的方法调用
	//4此公共方法只能通过类来调用，因此设置为欸static的，同时类的实例也必须为static声明的
	public static Singleton getInstance() {
		return instance;
	}
}