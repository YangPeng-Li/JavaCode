package abstractDemo;


/*
 * �ӿڵĶ�̬
 * �ӿ�������ʵ����֮��Ҳ���ڶ�̬
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
	
	public static void test1 (Runner r) { //������������ʵ������䷽�������ǲ��ܴ���ӿڶ������ֶ�̬ 
								  // Runnner r = new Duck(); �����ʵ����󸳸����������
		r.run();//���ⷽ���ĵ��� 			 
		
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
		System.out.println("Ѽ��Ҳ����·");
	}

	@Override
	public void Swing() {
		System.out.println("Ѽ�ӻ���Ӿ");
	}

	@Override
	public void fly() {
		System.out.println("Ѽ��Ҳ���");
	}
	
}