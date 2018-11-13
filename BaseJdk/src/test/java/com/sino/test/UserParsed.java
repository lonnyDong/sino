package com.sino.test;

import java.io.Serializable;

public class UserParsed implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String phone;
	private String address;

	private String filed;

	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserParsed [name=" + name + ", age=" + age + ", phone=" + phone + ", address=" + address + ", filed="
				+ filed + "]";
	}

}
