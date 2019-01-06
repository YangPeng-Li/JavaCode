package t4;

public class OverLoadingOrder {
	
	static void print (String s,int i)
	{
		System.out.println("String:"+s+" init: "+i);
	}
	
	static void print (int i, String s)
	{
		System.out.println("init: "+i+" String: "+s);
		
	}
	
	public static void main(String[] args) {
		print ("String first",11);
		print(99,"Int first");
	}

}
