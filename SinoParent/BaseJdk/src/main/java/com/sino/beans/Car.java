package com.sino.beans;

public abstract class Car {

    public String color;

    public String  brand;

    public void setColor(String color) {
        this.color = color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }
}
