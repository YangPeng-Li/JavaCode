package g13;

public class Grabage {
	public static void main(String[] args) {
		if(args.length ==0)
		{
			System.out.println("Usage: \n"+"java Grabge before \n"+"Java Garbage after");
			return;
		}
	
		while (!Chair.f)
		{
			new Chair();
			new String ("To take up sapce");
		}
		
	System.out.println(
	"After all Chairs have been created :\n"+"total create = "+Chair.created+
	", total finalized = "+Chair.finalized
			);
	if(args[0].equals("before")) {
		System.out.println("gc():");
		System.gc();
		System.out.println("runFinalization():");
		System.runFinalization();
	}
	
	System.out.println("bye");
	if(args[0].equals("after"))
	{
		System.runFinalizersOnExit(true);
	}
	
	
	
	
	}
	
}
