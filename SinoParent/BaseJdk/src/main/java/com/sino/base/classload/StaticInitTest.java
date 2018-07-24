package com.sino.base.classload;

public class StaticInitTest {
	
	static int value = 300;
	
	static {
		System.out.println("value 初始化："+value);
		System.out.println("加载静态代码块");
		value = 10;
	}
	
	
	static { 
		System.out.println("静态代码块1中value的值=" + value);
	}
	
 

	static String name = "林青霞"; 

	
	public static int getValue() {
		System.out.println("调用静态方法"+ value);
		return ++value;
	}
	
 
	public static void main(String[] args) {
 
		System.out.println("main value"+value);
 
	}
}