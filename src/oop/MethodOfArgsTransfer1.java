package oop;

public class MethodOfArgsTransfer1 {
	public static void main(String[] args) {
		MethodOfArgsTransfer1 tt = new MethodOfArgsTransfer1();
		DataSwap ds = new DataSwap();
		System.out.println("ds.i: "+ds.i+" ds.j: "+ds.j);
		
		tt.swap(ds);
		System.out.println("ds.i: "+ds.i+" ds.j: "+ds.j);
		
	}
	
	public void swap(DataSwap ds)
	{
		int temp = ds.i;
		 ds.i = ds.j;
		 ds.j = temp;
	}
	
}


class DataSwap 
{
	int i =5;
	int j =10;
}