package com.sino.base.reflect;

public abstract class Car {
	/** 颜色 */
	private String color;
	/** 品牌 */
	private String grand;

	/** 启动 */
	abstract void start();

	/** 暂停 */
	abstract void stop();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGrand() {
		return grand;
	}

	public void setGrand(String grand) {
		this.grand = grand;
	}
	
	

}
