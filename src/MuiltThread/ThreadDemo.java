package MuiltThread;

public class ThreadDemo extends Thread {
	
	private int i;
	//重写run()方法，run()方法就是线程的执行体

	 @Override
	public void run() {
		 
		 for (int i=0;i<=100; i++)
		 {
			 /**
			  * 当线程类继承Thread 类时，直接使用this 即可获取当前线程
			  * Thread 对象的getName()返回当前线程的名字
			  */
			 
			 
			 System.out.println("重写线程"+this.getName()+" "+i);
		 }
		 
		super.run();
	}
	
	 /**
	  * Thread.currentThread()：currentThread()是Thread
	  *  类的静态方法，该方法总是返回当前正在执行的线程对象
	  * @param args
	  */
	 
	public static void main(String[] args) {
		
		for (int i=0;i<=100;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		
			if(i ==20)
			{
				new ThreadDemo().start();
				new ThreadDemo().start();
			}
		}
		//使用继承Thread类的方法来创建线程类时，多个线程之间无法共享线程类的实例变量
		
	}
}
