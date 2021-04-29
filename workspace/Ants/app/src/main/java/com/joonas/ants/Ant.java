package com.joonas.ants;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Ant {
    private int x;
    private int y;
    private double xVelocity;
    private double yVelocity;
    private double velocity = 10;
    private double angle;
    private double turnAngle = 0.35;
    private int rangeMin = -10;
    private int rangeMax = 10;

    public Ant(int x, int y){
        this.x = x;
        this.y = y;
        angle = ThreadLocalRandom.current().nextDouble(0, Math.PI * 2);
        this.yVelocity = velocity * Math.cos(angle);
        this.xVelocity = velocity * Math.sin(angle);
    }

    public int[] getXY(){
        calculateVelocity();
        x = (int) Math.round(x + xVelocity);
        y = (int) Math.round(y + yVelocity);

        return new int[] {x, y};
    }

    public void xCollision(){

        angle = Math.PI + angle;
        //xVelocity = -xVelocity;
        //angle = Math.tan(yVelocity/xVelocity);
    }
    public void yCollision(){
        angle = Math.PI + angle;
        //yVelocity = -yVelocity;
        //angle = Math.tan(yVelocity/xVelocity);
    }

    private void calculateVelocity(){
        angle = angle + ThreadLocalRandom.current().nextDouble(-turnAngle/2, turnAngle/2);
        yVelocity = velocity * Math.cos(angle);
        xVelocity = velocity * Math.sin(angle);

    }
}
