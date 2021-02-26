package h_3_1;

public class BottleDispenser {
    private int bottles;
    private int money;
    private int prize;
    
    public BottleDispenser() {
        bottles = 5;
        money = 0;
        prize = 1;
    }
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Added more money!");
    }
    
    public void buyBottle() {
    	if (money < prize) {
    		System.out.println("Add money first!");
    	}
    	else {
    		if (bottles == 0) {
    			System.out.println("Out of bottles!");
    		}
    		else {
        bottles -= 1;
        money = money - prize;
        System.out.println("KACHUNK! A bottle came out of the dispenser!");
        if (money > 0) { 
    	returnMoney();
        }
    		}
    	}
    }
    
    public void returnMoney() {
        money = 0;
        System.out.println("Klink klink. Money came out!");
    }
}
