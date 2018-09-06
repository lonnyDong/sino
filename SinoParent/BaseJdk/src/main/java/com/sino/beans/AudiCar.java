package com.sino.beans;

public class AudiCar extends  Car {



    public AudiCar(String color) {
        super.brand = "AUDI";
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }



}
