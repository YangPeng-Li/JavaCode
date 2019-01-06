package oop.project_banking;

public class TestBanking {
	public static void main(String[] args) {
		Bank bank = new  Bank();
		Customer customer;
		Account account;
		
		bank.addCustomer("Jane","Sime");
		account = new SavingAccount(500,0.03);
		customer = bank.getCustomer(0);
		customer.serAccount(account);
	}
}
