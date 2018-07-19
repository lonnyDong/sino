package com.sino.beans;


public class Dog extends  Animal{

    private  String barking;

    private  String running;

    public String getBarking() {
        return barking;
    }

    public void setBarking(String barking) {
        this.barking = barking;
    }

    public String getRunning() {
        return running;
    }

    public void setRunning(String running) {
        this.running = running;
    }


    @Override
    public void bark(String barking) {
        this.barking = barking;
        System.out.println(this.barking);
    }

    @Override
    public void runnning(String running) {
        this.running = running;
        System.out.println(this.barking);
    }

    public Dog(String barking, String running) {
        this.barking = barking;
        this.running = running;
    }

    public Dog() {
    }
}
