package oop.moreStatus;

public class Woman {
	private boolean smoking ;

	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}

	public Woman() {
		super();
	}
	
	public void eat () {
		System.out.println("女人合理吃肉");
	}
	public void walk() {
		System.out.println("女人恰似一江春水向东流");
	}
	public void shopping() {
		System.out.println("女人购物");
	}
}
