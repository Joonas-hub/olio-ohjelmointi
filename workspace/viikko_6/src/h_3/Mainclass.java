package h_3;

import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int selection;
		String accNumber;
		int money;
		int creditLimit;
		
		Bank bank = new Bank();
		
		System.out.println("\n*** BANK SYSTEM ***");
		System.out.println("1) Add a regular account");
		System.out.println("2) Add a credit account");
		System.out.println("3) Deposit money");
		System.out.println("4) Withdraw money");
		System.out.println("5) Remove an account");
		System.out.println("6) Print account information");
		System.out.println("7) Print all accounts");
		System.out.println("0) Quit");
		System.out.print("Your choice: ");
		
		selection = scan.nextInt();
		
		while (selection != 0) {
			switch(selection) {
			case 1:
				System.out.print("Give an account number: ");
				accNumber = scan.next();
				System.out.print("Amount of money to deposit: ");
				money = scan.nextInt();
				bank.addAccount(accNumber, money);
				break;
			case 2:
				System.out.print("Give an account number: ");
				accNumber = scan.next();
				System.out.print("Amount of money to deposit: ");
				money = scan.nextInt();
				System.out.print("Give a credit limit: ");
				creditLimit = scan.nextInt();
				
				bank.addAccount(accNumber, money, creditLimit);
				break;
			case 3:
				System.out.print("Give an account number: ");
				accNumber = scan.next();
				System.out.print("Amount of money to deposit: ");
				money = scan.nextInt();
				bank.deposit(accNumber, money);
				//System.out.println("Depositing to the account: " + accNumber + " the amount " + money);
						
				break;
			case 4:
				System.out.print("Give an account number: ");
				accNumber = scan.next();
				System.out.print("Amount of money to withdraw: ");
				money = scan.nextInt();
				bank.withdraw(accNumber, money);
				
				//System.out.println("Withdrawing from the account: " + accNumber + " the amount " + money);
								
				break;
			case 5:
				System.out.print("Give the account number of the account to delete: ");
				accNumber = scan.next();
				
				bank.deleteAccount(accNumber);			
				break;
			case 6:
				System.out.print("Give the account number of the account to print information from: ");
				accNumber = scan.next();
				bank.findAccount(accNumber);				
				break;
			case 7:
				System.out.println("All accounts:");
				bank.printAll();
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}

			System.out.println("\n*** BANK SYSTEM ***");
			System.out.println("1) Add a regular account");
			System.out.println("2) Add a credit account");
			System.out.println("3) Deposit money");
			System.out.println("4) Withdraw money");
			System.out.println("5) Remove an account");
			System.out.println("6) Print account information");
			System.out.println("7) Print all accounts");
			System.out.println("0) Quit");
			System.out.print("Your choice: ");
			selection = scan.nextInt();
		}
		
		scan.close();
		
	}

}
