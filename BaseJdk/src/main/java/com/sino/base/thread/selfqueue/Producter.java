package com.sino.base.thread.selfqueue;

import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;

/**
 * 生产者
 * @author lonny
 *
 */
public class Producter {

	public String generateNum() {

		return RandomUtils.nextLong() + "";
	}
	
	public static void main(String[] args) {
		for (int i =0;i<=10;i++) {
			
			String generateNum = new Producter().generateNum();
			System.out.println(generateNum);
		}
		
	}
	
}
