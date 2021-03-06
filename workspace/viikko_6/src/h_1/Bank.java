package h_1;

import java.util.ArrayList;

public class Bank {

	ArrayList<String> accountList = new ArrayList<String>();
	
	public void addAccount(String accountNumber, int money) {
		accountList.add(accountNumber);
		System.out.println("Adding to bank: " + accountNumber + "," + money);
	}
	
	public void addAccount(String accountNumber, int money, int credit) {
		accountList.add(accountNumber);
		System.out.println("Adding to bank: " + accountNumber + "," + money + "," + credit);
	}
	
	public void deleteAccount(String accountNumber) {
		accountList.remove(accountNumber);
		System.out.println("Account removed.");
	}
	
	public String findAccount(String accountNumber) {
		
		System.out.println("Searching for account: " + accountNumber);
		if (accountList.contains(accountNumber)) {
			return accountList.get(accountList.indexOf(accountNumber));
		}
		else {
			return null;
		}
	}
}
