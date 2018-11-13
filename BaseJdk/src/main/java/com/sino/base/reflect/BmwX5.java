package com.sino.base.reflect;

public class BmwX5 extends Car {

	@Override
	void start() {
		String color2 = this.getColor();

		System.out.println(color2 + "BMW x5启动成功");

	}

	@Override
	void stop() {

		String grand2 = this.getGrand();
		System.out.println(grand2 + "BMW x5停车>>>");

	}
	
	
	private void startEnginee() {
		
		
		System.out.println("BMW 启动引擎");
		
	}
	
	public Boolean startTap(String param) {
		
		
		return true;
		
	}

}
