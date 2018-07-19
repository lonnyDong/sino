package com.sino.middle_ware.bean;

import java.io.Serializable;

public class City implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private int  id;
	
	private String name;

	private String simpleName;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public City() {
		super();
	}

	public City(String name, String simpleName) {
		super();
		this.name = name;
		this.simpleName = simpleName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", simpleName=" + simpleName + "]";
	}

}
