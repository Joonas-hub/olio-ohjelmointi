package com.example.viikko_8;

public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    private double size;
    private double price;
    private int amount;

    public Bottle(){
        name = "Pepsi Max";
        manufacturer = "Pepsi";
        total_energy = 0.3;
        size = 0.5;
        price = 1.8;
        amount = 1;
    }
    public Bottle(String name, String manuf, double totE, double size, double prize, int amount){
        this.name = name;
        manufacturer = manuf;
        total_energy = totE;
        this.size = size;
        this.price = prize;
        this.amount = amount;
    }

    public String getName(){
        return name;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public double getEnergy(){
        return total_energy;
    }
    public double getSize() {
        return size;
    }
    public double getPrice() {
        return price;
    }
    public int getAmount(){ return amount;}
    public void remove(){amount -= 1;}
}