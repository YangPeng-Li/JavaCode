package oop.moreStatus;
/*
 * 多态
 */
public class Polymorphism {
	
}
class man extends Person {
	private boolean smoking ;
	String id ="子类属性";
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
		System.out.println("男人合理吃肉");
	}
	public void walk() {
		System.out.println("男人稳重的走路");
	}
	public void entertainment(){
		System.out.println("男人吃饭请客");
	}
}