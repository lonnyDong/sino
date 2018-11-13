package com.sino.guava;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class GuavaCache {

	 
	static Cache<String, String> cache = CacheBuilder.newBuilder()
			.maximumSize(1000)
			.expireAfterAccess(5L, TimeUnit.SECONDS)
			.build();

	
	public static void main(String[] args) {
//		cache.put("123", "value");
//		
//		String ifPresent = cache.getIfPresent("123");
//
//		System.out.println(ifPresent);
//		String ifPresent1 = cache.getIfPresent("1231");
		
		int a=8;
		System.out.println(8==a++);
		System.out.println(a);
		
		phone("18576498771");
		
	}
	
	public static void phone(String phone) {
		String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
		if (!Pattern.matches(regex, phone)) {
			System.err.println("error");
		}else {
			System.out.println("ok");
		}
	}
}
