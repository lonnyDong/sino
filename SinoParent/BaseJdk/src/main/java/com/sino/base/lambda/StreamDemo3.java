package com.sino.base.lambda;

import java.util.Arrays;
import java.util.List;

public class StreamDemo3 {
	public static void main(String[] args) {
		test2();
	}
	
	private static void test2() {
		Student s1 = new Student();
		s1.setAge(12);
		s1.setName("lili");
		
		Student s2= new Student();
		s2.setAge(612);
		s2.setName("gfli");
		
		Student s3 = new Student();
		s3.setAge(112);
		s3.setName("123li");

		List<Student> asList = Arrays.asList(s1,s2,s3);
		asList.forEach(item ->save(item));
	}

	private static void save(Student item) {
		System.out.println(item.name);
	}
}
