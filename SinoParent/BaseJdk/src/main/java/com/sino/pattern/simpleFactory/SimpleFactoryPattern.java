package com.sino.pattern.simpleFactory;
import com.sino.beans.AudiCar;
import com.sino.beans.Car;

/**
 * 工厂模式
 */

public class SimpleFactoryPattern {

    public static void main(String[] args) {

        Car red = SimpleFactory.createCar(1, "red");

        System.out.println("车子品牌"+red.getBrand());
        System.out.println("车子颜色"+red.getColor());

        Car green = SimpleFactory.createCar(2, "green");

        if(green instanceof AudiCar){
            AudiCar green1 = (AudiCar) green;
            System.out.println("车子品牌"+green1.getBrand());
            System.out.println("车子颜色"+green1.getColor());

        }


    }






}




