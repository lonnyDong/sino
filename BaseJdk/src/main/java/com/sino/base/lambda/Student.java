package com.sino.base.lambda;


public class Student extends Person{

	String name;
	int age;
	String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Student() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", status=" + status + "]";
	}
	
	
	@Override
	void speak() {
		
		System.out.println("i am a student");
	}
	
	
}
