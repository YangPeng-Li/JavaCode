package oop.moreStatus;


/*
 * 
 */
public class TrainOfSecond {
	public static void main(String[] args) {
		
		
	}
	//判断两个对象的面积是否相等
	
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
		 * 为什么子类必须调用父类的构造器
		 * 如果不需要你为什么要去继承父类构造器？
		 * ①父类中有这些成员变量的初始化方法，（如果你不觉的麻烦可以在写一遍）减少工作量
		 * ②对父类的属性方法的扩展
		 * ③语法要求不写就是错误
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


