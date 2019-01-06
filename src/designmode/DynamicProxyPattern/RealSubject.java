package designmode.DynamicProxyPattern;


public class RealSubject implements Subject {

	@Override
	public int sellBooks() {
		System.out.println("∂¡ È");
		return 1;
	}

	@Override
	public String speak() {
		System.out.println("Àµª∞");
		return "ZF";
	}
}
