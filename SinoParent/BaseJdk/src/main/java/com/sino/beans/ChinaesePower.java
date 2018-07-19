package com.sino.beans;

/**
 *220
 */
public class ChinaesePower extends CommonPower {

	private int voltage;
	private int current;

	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public ChinaesePower(int voltage, int current) {
		super();
		this.voltage = voltage;
		this.current = current;
	}

	public ChinaesePower() {
		super();
	}

}
