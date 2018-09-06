package com.sino.pattern.simpleFactory;

import com.sino.beans.AudiCar;
import com.sino.beans.BanzCar;
import com.sino.beans.Car;

/**
 * 想要什么样的车都可以造出来
 */
public class SimpleFactory {

	public static Car createCar(int type, String color) {

		if (type == 1) {
			BanzCar car = new BanzCar(color);
			car.setBrand("b");
			car.setColor("color");

			return car;
		} else if (type == 2) {
			AudiCar audiCar = new AudiCar(color);

			audiCar.setColor(color);
			return audiCar;
		}

		return null;

	}

}