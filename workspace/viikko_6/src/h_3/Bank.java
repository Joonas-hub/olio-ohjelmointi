package h_3;

import java.util.ArrayList;

public class Bank {

	ArrayList<Account> accountList = new ArrayList<Account>();
	
	public void addAccount(String accountNumber, int money) {
		accountList.add(new RegularAccount(accountNumber, money));
		//System.out.println("Adding to bank: " + accountNumber + "," + money);
	}
	
	public void addAccount(String accountNumber, int money, int credit) {
		accountList.add(new CreditAccount(accountNumber, money, credit));
		//System.out.println("Adding to bank: " + accountNumber + "," + money + "," + credit);
	}
	
	public void deleteAccount(String accountNumber) {
		int idx = -1;
		for (Account A : accountList) {
			if (accountNumber.equals(A.getAccountNumber())){
				idx = accountList.indexOf(A);
				
			}
		}
		if (idx != -1) {
			accountList.remove(idx);
		}
		
		//accountList.remove(accountNumber);
		System.out.println("Account removed.");
	}
	public void withdraw(String accountNumber, int money) {
		for (Account A : accountList) {
			if (accountNumber.equals(A.getAccountNumber())){
				A.withdraw(money);
			}
		}
	}
	
	public void deposit(String accountNumber, int money) {
		for (Account A : accountList) {
			if (accountNumber.equals(A.getAccountNumber())){
				A.deposit(money);
			}
		}
	}	
	public void printAll() {
		for (Account A : accountList) {
			if (A instanceof RegularAccount) {
			System.out.println("Account number: " + A.getAccountNumber() + " Amount of money: " + A.getMoney());
			}
			else if (A instanceof CreditAccount) {
				System.out.println("Account number: " + A.getAccountNumber() + " Amount of money: " + A.getMoney() + " Credit limit: " + ((CreditAccount) A).getCredit());
			}
		}
	}
	public void findAccount(String accountNumber) {
		
		//System.out.println("Searching for account: " + accountNumber);
		for (Account A : accountList) {
			if (accountNumber.equals(A.getAccountNumber())){
				if (A instanceof RegularAccount) {
				System.out.println("Account number: " + A.getAccountNumber() + " Amount of money: " + A.getMoney());
				}
				else if (A instanceof CreditAccount) {
					System.out.println("Account number: " + A.getAccountNumber() + " Amount of money: " + A.getMoney() + " Credit limit: " + ((CreditAccount) A).getCredit());
				}
			}
		}	
	}
		
		
		//if (accountList.contains(accountNumber)) {
		//	return accountList.get(accountList.indexOf(accountNumber));
		//}
		//else {
		//	return null;
		//}
	//}
}
