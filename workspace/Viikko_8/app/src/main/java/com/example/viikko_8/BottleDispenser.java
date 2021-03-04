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
    private String lastPurchase = "";
    private BottleDispenser() {
        bottles = 5;
        money = 0;

        bottle_array.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8, bottles));
        bottle_array.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 1.5, 2.2, bottles));
        bottle_array.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 0.5, 2.0, bottles));
        bottle_array.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 1.5, 2.5, bottles));
        bottle_array.add(new Bottle("Fanta Zero", "Pepsi", 0.3, 0.5, 1.95, bottles));

    }

    public static BottleDispenser getInstance(){
        return bd;
    }

    public void addMoney(int money) {
        this.money += money;
        System.out.println("Klink! Added more money!");
    }

    public int buyBottle(int selection) {

        price = bottle_array.get(selection - 1).getPrice();
        if (money < price) {
            System.out.println("Add money first!");
            return 2;
        }
        else {
            if (bottle_array.get(selection - 1).getAmount() == 0) {
                System.out.println("Out of bottles!");
                return 1;
            }
            else {

                bottle_name = bottle_array.get(selection - 1).getName();
                bottle_array.get(selection - 1).remove();

                money = money - price;
                System.out.println("KACHUNK! " + bottle_name + " came out of the dispenser!");
                lastPurchase = bottle_name + "\t" + String.valueOf(price) + " €";
                return 0;
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

    public ArrayList<Bottle> getBottleArray(){
        return bottle_array;
    }

    public String getLastPurchase(){ return lastPurchase; }
}
