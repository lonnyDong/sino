package com.sino.base.lambda;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

//
public class Security {

	public static void main(String[] args) {
		
		SecureRandom secureRandom = new SecureRandom();
		byte [] b = new byte[32];
		secureRandom.nextBytes(b);
		
		int nextInt2 = secureRandom.nextInt();
		System.out.println("nextint :"+nextInt2);
		
		
		try {
			//随机数
			long nextLong = SecureRandom.getInstanceStrong().nextLong();
			System.out.println(Math.abs(nextLong));
			
			SecureRandom instanceStrong = SecureRandom.getInstanceStrong();
			int nextInt = instanceStrong.nextInt();
			System.out.println(nextInt);//-938143604
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
