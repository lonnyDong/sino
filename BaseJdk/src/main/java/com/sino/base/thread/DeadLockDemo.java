package com.sino.base.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁测试
 */
public class DeadLockDemo {

	public static void main(String[] args) {

		Lock lockA = new ReentrantLock();
		Lock lockB = new ReentrantLock();

		new Thread(() -> {
			lockA.lock();
			try {

				System.out.println("拿到A 锁");
				lockB.lock();
				try {

					System.out.println("拿到B 锁");

				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();

	}

}
