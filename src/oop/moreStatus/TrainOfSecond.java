package oop.moreStatus;


/*
 * 
 */
public class TrainOfSecond {
	public static void main(String[] args) {
		
		
	}
	//�ж��������������Ƿ����
	
	public boolean equlasArea(GeometricObject o1, GeometricObject o2) {
/*		if(o1.findArea() == o2.findArea()){
			return true;
		}
		else 
			return false;*/
		return o1.findArea() == o2.findArea();
	}
	
	public void displaygeometricObject(GeometricObject o) {
	System.out.println(o.findArea());
	}
	
}
class GeometricObject{
	protected String color;
	protected double weight;
	protected GeometricObject(String color,double weight) {
		this.color = color;
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double findArea() {
		return 0;
	}

}

class Circle extends GeometricObject {
	private double radius;
	public Circle (double radius,String color,double weight ) {
		/*
		 * Ϊʲô���������ø���Ĺ�����
		 * �������Ҫ��ΪʲôҪȥ�̳и��๹������
		 * �ٸ���������Щ��Ա�����ĳ�ʼ��������������㲻�����鷳������дһ�飩���ٹ�����
		 * �ڶԸ�������Է�������չ
		 * ���﷨Ҫ��д���Ǵ���
		 *
		 */
		super(color,weight);
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double findArea() {
		return Math.PI*radius*radius ;
	}
}

class MyRectangle extends GeometricObject{
	private double width;
	private double height;
	public MyRectangle (double width,double height,String color,double weight) {
		super (color,weight);
		this.width = width;
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double findArea() {
		return width*height;
	}
}


