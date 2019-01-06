package oop.project_banking;

/*
 * ´¢ĞîÕË»§
 */
public class SavingAccount extends Account {
	
	private double interesRate; //ÀûÂÊ
	
	public double getInteresRate() {
		return interesRate;
	}

	public void setInteresRate(double interesRate) {
		this.interesRate = interesRate;
	}

	public SavingAccount (double balance ,double init_rate) {
		super(balance);
		this.interesRate = init_rate;
	}
}
