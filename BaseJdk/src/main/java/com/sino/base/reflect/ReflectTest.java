package com.sino.base.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class ReflectTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		try {
			Class<?> clazz = Class.forName("com.sino.base.reflect.BmwX5");

			System.out.println("name:" + clazz.getName());
			System.out.println("SimpleName:" + clazz.getSimpleName());
			System.out.println("CanonicalName:" + clazz.getCanonicalName());
			System.out.println("TypeName:" + clazz.getTypeName());
			System.out.println("Modifiers:" + clazz.getModifiers());
			System.out.println("Modifiers:" + clazz.getSuperclass());
			BmwX5 bmwX5 = (BmwX5) clazz.newInstance();
			Method[] methods = clazz.getMethods();
			TypeVariable<?>[] typeParameters = clazz.getTypeParameters();
			Field[] fields = clazz.getFields();

			Class<?>[] interfaces = clazz.getInterfaces();

			bmwX5.setColor("RED");
			bmwX5.setGrand("BMW");
			bmwX5.start();
			bmwX5.stop();

			/*
			 * Method类，方法的对象 一个成员方法就是一个Method对象 getMethods()方法获取的是所有的public的函数，包括父类继承而来的
			 * getDeclaredMethods()获取的是多有该类自己声明的方法，不问访问权限
			 */
			Method[] ms = clazz.getDeclaredMethods();
			for (int i = 0; i < ms.length; i++) {
				// 得到方法的返回值类型的类类型
				Class retrunType = ms[i].getReturnType();
				System.out.print(retrunType.getName() + " ");
				// 得到方法的名称
				System.out.print(ms[i].getName() + "(");
				// 获取的参数类型--->得到的是参数列表的类型的类类型
				Class[] paraTypes = ms[i].getParameterTypes();
				for (Class class1 : paraTypes) {
					System.out.print(class1.getName() + ",");
				}
				System.out.println(")");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
