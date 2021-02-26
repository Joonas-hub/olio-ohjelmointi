package h_3_2;

public class BottleDispenser {
	private int bottles;
    // The array for the Bottle-objects
    private Bottle[] bottle_array;
    private int money;
    private int prize;
    private String bottle_name;
    
    public BottleDispenser() {
        bottles = 50;
        money = 0;
        prize = 1;
        // Initialize the array
        bottle_array = new Bottle[bottles];
        // Add Bottle-objects to the array
        for(int i = 0;i<bottles;i++) {
            // Use the default constructor to create new Bottles
            bottle_array[i] = new Bottle();
        }
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

        bottle_name = bottle_array[bottles - 1].getName();
        bottles -= 1;
        money = money - prize;
        System.out.println("KACHUNK! " + bottle_name + " came out of the dispenser!");
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
