package designmode.SinglePattern;

public class Singleton0 {

	private static  Singleton0 singleton = new Singleton0() ;
	private Singleton0 () {
	}
	public static Singleton0 getInstance ()
	{
		return singleton;
	}
}
