package h_3_3;

import java.util.ArrayList;

public class BottleDispenser {
	private int bottles;
    // The array for the Bottle-objects
    private ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();
    private double money;
    //private int prize;
    private String bottle_name;
    private double price;
    private int j;
    
    public BottleDispenser() {
        bottles = 5;
        money = 0;
        //prize = 1;
        // Initialize the array
        //bottle_array = new Bottle[bottles];
        // Add Bottle-objects to the array
        for(int i = 0;i<bottles;i++) {
            // Use the default constructor to create new Bottles
            //bottle_array[i] = new Bottle();
        	bottle_array.add(new Bottle());
        }
    }
    
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Added more money!");
    }
    
    public void buyBottle() {
    	price = bottle_array.get(0).getPrice();
    	if (money < price) {
    		System.out.println("Add money first!");
    	}
    	else {
    		if (bottles == 0) {
    			System.out.println("Out of bottles!");
    		}
    		else {

        bottle_name = bottle_array.get(0).getName();
        bottle_array.remove(0);
        bottles -= 1;
        money = money - price;
        System.out.println("KACHUNK! " + bottle_name + " came out of the dispenser!");
        if (money > 0) { 
    	//returnMoney();
        }
    		}
    	}
    }
    
    public void returnMoney() {
    	if (money > 0) {
            money = 0;
            System.out.println("Klink klink. Money came out!");
    	}
    	else {
    		System.out.println("No money left!");
    	}
    }
    public void listBottles() {
    	j = 1;
    	for (Bottle i : bottle_array) {
    		System.out.println(j + ". "+"Name: " + i.getName() + "\n\tSize: " + i.getSize() + "\tPrice: " + i.getPrice());
    		j++;
    	}
    }
}
