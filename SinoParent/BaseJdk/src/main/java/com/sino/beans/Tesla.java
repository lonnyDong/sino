package com.sino.beans;

/**
 * Tesla 不可变
 */
public class Tesla extends Car {
	/**
	 * 能源
	 */
	private String energy;
	/**
	 * 发动机型号
	 */
	private String engineType;

	/**
	 * 车门个数
	 */
	private int door;

	/**
	 * 是否安装abs系统
	 */
	private Boolean isAbs;

	/**
	 * 是否安装空调
	 */
	private Boolean isAirConditioner;
	/**
	 * 是否有天窗
	 */
	private Boolean skyWindow;

	/**
	 * 只能够通过builder 构建
	 * 
	 * @param builder
	 */
	private Tesla(Builder builder) {
		this.door = builder.door;
		this.energy = builder.energy;
		this.engineType = builder.engineType;
		this.isAbs = builder.isAbs;
		this.isAirConditioner = builder.isAirConditioner;
		this.skyWindow = builder.skyWindow;
		this.brand = builder.brand;
		this.color = builder.color;

	}

	
	
	
	
	
	@Override
	public String toString() {
		return "Tesla [energy=" + energy + ", engineType=" + engineType + ", door=" + door + ", isAbs=" + isAbs
				+ ", isAirConditioner=" + isAirConditioner + ", skyWindow=" + skyWindow + "]";
	}






	public static class Builder extends Car {

		/**
		 * 能源
		 */
		private String energy;
		/**
		 * 发动机型号
		 */
		private String engineType;

		/**
		 * 车门个数
		 */
		private int door;

		/**
		 * 是否安装abs系统
		 */
		private Boolean isAbs;

		/**
		 * 是否安装空调
		 */
		private Boolean isAirConditioner;
		/**
		 * 是否有天窗
		 */
		private Boolean skyWindow;

		/**
		 * 最简单的车
		 * 
		 * @param energy
		 * @param engineType
		 */
		public Builder builder(String energy, String engineType) {
			this.energy = energy;
			this.engineType = engineType;
			return this;
		}

		/**
		 * 带门的车
		 * 
		 * @param energy
		 * @param engineType
		 * @param door
		 * @param isAbs
		 */
		public Builder builder(String energy, String engineType, int door, Boolean isAbs) {

			this.energy = energy;
			this.engineType = engineType;
			this.door = door;
			this.isAbs = isAbs;
			return this;
		}

		/**
		 * 豪车
		 * 
		 * @param energy
		 * @param engineType
		 * @param door
		 * @param isAbs
		 */
		public Builder builder(String energy, String engineType, int door, Boolean isAbs, Boolean isAirConditioner,
				Boolean skyWindow) {
			this.energy = energy;
			this.engineType = engineType;
			this.door = door;
			this.isAbs = isAbs;
			this.isAirConditioner = isAirConditioner;
			this.skyWindow = skyWindow;
			return this;
		}

		public Tesla build() {
			return new Tesla(this);
		}

	}

}
