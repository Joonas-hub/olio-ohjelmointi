package h_3;

public abstract class Account {
	protected String accountNumber = "";
	protected int money = 0;
	
	public Account(String accountNumber, int money) {
		this.accountNumber = accountNumber;
		this.money = money;
		System.out.println("Account created.");
	}
	
	public void withdraw(int money) {
		if (this.money >= money) {
			this.money = this.money - money;
		}
		else {
			System.out.println("Not enough money!");
		}
	}
	
	public void deposit(int money) {
		this.money = this.money + money;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public int getMoney() {
		return money;
	}
	/*public String[] getInfo() {
		String[] array = {accountNumber,money}
		return array;
	}*/
}

class RegularAccount extends Account{
	public RegularAccount(String accountNumber, int money) {
		super(accountNumber, money);
	}
}

class CreditAccount extends Account{
	private int credit;
	
	public CreditAccount(String accountNumber, int money, int credit) {
		super(accountNumber, money);
		this.credit = credit;
	}
	
	public int getCredit() {
		return credit;
	}
	
	@Override
	public void withdraw(int money) {
		if (this.money + this.credit >= money) {
			this.money = this.money - money;
		}
		else {
			System.out.println("Not enough money!");
		}
	}
}












