package oop.moreStatus;
/*
 * ��̬
 */
public class Polymorphism {
	
}
class man extends Person {
	private boolean smoking ;
	String id ="��������";
	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}

	public man() {
		super();
	}
	
	public void eat () {
		System.out.println("���˺������");
	}
	public void walk() {
		System.out.println("�������ص���·");
	}
	public void entertainment(){
		System.out.println("���˳Է����");
	}
}