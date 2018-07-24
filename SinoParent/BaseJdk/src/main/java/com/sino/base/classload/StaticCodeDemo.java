package com.sino.base.classload;

class StaticCode {
	static int x = 10;
	static int y = show();
 
	static int show() {
		System.out.println("show..........x = " + x);
		System.out.println("show..........y = " + y);
		return 100;
	}
 
	// 静态代码块
	static {
		System.out.println("静态代码块运行....y= " + y);
	}
 
	void print() {
		System.out.println("....................");
	}
}
 
public class StaticCodeDemo {
	public static void main(String[] args) {
		new StaticCode().print();
	}
}