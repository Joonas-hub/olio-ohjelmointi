package com.example.viikko_8;

import android.view.View;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BottleDispenser {
    private int bottles;
    private ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();
    private double money;
    private String bottle_name;
    private double price;
    private int j;
    private static BottleDispenser bd = new BottleDispenser();

    private BottleDispenser() {
        bottles = 5;
        money = 0;

        bottle_array.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8));
        bottle_array.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 1.5, 2.2));
        bottle_array.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 0.5, 2.0));
        bottle_array.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 1.5, 2.5));
        bottle_array.add(new Bottle("Fanta Zero", "Pepsi", 0.3, 0.5, 1.95));

    }

    public static BottleDispenser getInstance(){
        return bd;
    }

    public void addMoney(int money) {
        this.money += money;
        System.out.println("Klink! Added more money!");
    }

    public void buyBottle(int selection) {

        price = bottle_array.get(selection - 1).getPrice();
        if (money < price) {
            System.out.println("Add money first!");
        }
        else {
            if (bottles == 0) {
                System.out.println("Out of bottles!");
            }
            else {

                bottle_name = bottle_array.get(selection - 1).getName();
                bottle_array.remove(selection - 1);
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
            String money_formatted = String.format("%.02f", money);
            System.out.println("Klink klink. Money came out! You got " + money_formatted + "€ back");
            money = 0;
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
    public double getMoney(){
        return money;
    }
}
