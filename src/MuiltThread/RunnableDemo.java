package MuiltThread;


/**
 * 
 * 
 *	@author Lyp
 * 2018��11��29��
 * ����10:36:57
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
				new Thread (rb,"���߳�1").start();
				new Thread (rb,"���߳�2").start();
			}
		}
	}
	

}
