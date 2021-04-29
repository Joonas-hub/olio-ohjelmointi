package com.example.viikko_9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

class X {
    String name;
    int size;
    double prize;

    X(String n, int s, double p) {
        name = n;
        size = s;
        prize = p;

    }
    public void writeToAFile() {
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(new File("data.txt")));
            br.write(this.name);
        } catch (IOException ex) {
            System.err.println("Something went wrong.");
        }
    }
}

class A extends X {
    double weight;

    A(String n, int s, double p, double w) {
        super(n, s, p);
        weight = w;
    }

}

class B extends X implements Serializable {
    double lenght;

    B(String n, int s, double p, double l) {
        super(n, s, p);
        lenght = l;
    }

    public float getUltimateValue() {
        return (float) (size * prize / Math.sqrt(lenght));
    }
}

public class Exam2 {

    public static void main(String[] args) {
        A a = new A("A", 10, 2.2, 77.5);
        B b = new B("B", 10, 2.2, 77.5);

        b.writeToAFile();
    }
}


