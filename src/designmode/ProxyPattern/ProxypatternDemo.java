package designmode.ProxyPattern;

public class ProxypatternDemo {
	public static void main(String[] args) {
		Image image  =  new ProxyImage("france.jpg");
		
		//图像将从磁盘加载
		image.display();
		System.out.println("");
		//图像不需要从磁盘加载
		image.display();
		
		
	}

}
