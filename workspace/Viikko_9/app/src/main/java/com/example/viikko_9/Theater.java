package com.example.viikko_9;

public class Theater {

    private int id = 0;
    private String name ="";

    public Theater(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
