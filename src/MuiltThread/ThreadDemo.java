package MuiltThread;

public class ThreadDemo extends Thread {
	
	private int i;
	//��дrun()������run()���������̵߳�ִ����

	 @Override
	public void run() {
		 
		 for (int i=0;i<=100; i++)
		 {
			 /**
			  * ���߳���̳�Thread ��ʱ��ֱ��ʹ��this ���ɻ�ȡ��ǰ�߳�
			  * Thread �����getName()���ص�ǰ�̵߳�����
			  */
			 
			 
			 System.out.println("��д�߳�"+this.getName()+" "+i);
		 }
		 
		super.run();
	}
	
	 /**
	  * Thread.currentThread()��currentThread()��Thread
	  *  ��ľ�̬�������÷������Ƿ��ص�ǰ����ִ�е��̶߳���
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
		//ʹ�ü̳�Thread��ķ����������߳���ʱ������߳�֮���޷������߳����ʵ������
		
	}
}
