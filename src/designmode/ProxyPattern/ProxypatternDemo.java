package designmode.ProxyPattern;

public class ProxypatternDemo {
	public static void main(String[] args) {
		Image image  =  new ProxyImage("france.jpg");
		
		//ͼ�񽫴Ӵ��̼���
		image.display();
		System.out.println("");
		//ͼ����Ҫ�Ӵ��̼���
		image.display();
		
		
	}

}
