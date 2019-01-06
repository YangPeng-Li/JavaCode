package abstractDemo;


/*
 * 接口的多态
 * 接口与具体的实现类之间也存在多态
 */
public class MoreStatusOfInterface {
	
	public static void main(String[] args) {
		Duck d = new Duck();
	
		MoreStatusOfInterface.test1(d);
		MoreStatusOfInterface.test2(d);
		MoreStatusOfInterface.test3(d);
		d.run();
		d.fly();
		d.Swing();
		
	}
	
	public static void test1 (Runner r) { //可以声明，有实现类调其方法，但是不能创造接口对象，体现多态 
								  // Runnner r = new Duck(); 子类的实体对象赋给父类的引用
		r.run();//虚拟方法的调用 			 
		
	}
	public static void test2(Swimmer s) { //Swimmer s = new Duck();
		
		s.Swing();
	}
	public static void test3 (Fliter f) { //Fliter f = new Duck();
		f.fly();
	}
	
	
}
interface Runner{
	public abstract void run();
}
interface Swimmer{
	void Swing();
}
interface  Fliter {
	void fly();
}

class Duck implements Runner,Swimmer,Fliter{

	@Override
	public void run() {
		System.out.println("鸭子也会走路");
	}

	@Override
	public void Swing() {
		System.out.println("鸭子会游泳");
	}

	@Override
	public void fly() {
		System.out.println("鸭子也会飞");
	}
	
}