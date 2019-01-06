package MuiltThread;


/**
 * 
 * 
 *	@author Lyp
 * 2018年11月29日
 * 上午10:36:57
 */
public class RunnableDemo implements Runnable{

	@Override
	public void run() {
		
		
	}
	public static void main(String[] args) {
		for(int i=0 ;i<=100;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20)
			{
				RunnableDemo rb = new RunnableDemo();
				new Thread (rb,"新线程1").start();
				new Thread (rb,"新线程2").start();
			}
		}
	}
	

}
