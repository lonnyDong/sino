package com.sino.beans;

public class BanzCar extends  Car {

    private String brand;

    public BanzCar() {
    }

    public BanzCar(String color) {

        super.color = color;
        this.brand = "banz";
    }


}
