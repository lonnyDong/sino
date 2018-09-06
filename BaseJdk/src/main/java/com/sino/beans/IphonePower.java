package com.sino.beans;

public class IphonePower {

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

	@Override
	public String toString() {
		return "IphonePower [voltage=" + voltage + ", current=" + current + "]";
	}

}
