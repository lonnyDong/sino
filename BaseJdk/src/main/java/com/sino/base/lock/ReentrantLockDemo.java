package com.sino.base.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁
 * @author lonny
 *
 */
public class ReentrantLockDemo {

	
	ReentrantLock reentrantLock = new ReentrantLock();
	
	public static void main(String[] args) {
		ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 200; i++) {
			int factorial = reentrantLockDemo.factorial(30);
			System.out.println(factorial);
		}
		long end = System.currentTimeMillis();
		System.out.println("执行时间" + (end - start));
	}
	
	
	
	
	
	/**
	 * 阶乘递归
	 * @return
	 */
	synchronized private  int factorial(int n) {
		
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}
	
}
