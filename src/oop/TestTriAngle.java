package oop;

/*
 * This 关键字的使用
 * 
 * 
 * 
 */


public class TestTriAngle {
	public static void main(String[] args) {
		TriAngle t = new TriAngle();
		t.setBase(2.3);
		t.setHeight(1.2);
		t.getArea();
	}

}

class TriAngle {
	
	private double base;//底边长
	private double height;//高
	
	public double getBase () {
		return base;
	}
	public double getHeight() {
		return height;
	}
	
	public void  setBase (double base) {
		 this.base = base ;
	}
	
	public void setHeight(double height) {
		 this.height=height ;
	}
	
	public double getArea() {
		return base*height/2;
		//return this.base*this.height/2;
	}
}