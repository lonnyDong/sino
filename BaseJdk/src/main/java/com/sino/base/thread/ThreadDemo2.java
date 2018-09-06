package com.sino.base.thread;

public class ThreadDemo2 {

	public static void main(String[] args) {

		System.out.println("main start");

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName());
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName());
					System.out.println(Thread.currentThread().isDaemon());
				}
			}
		});
		
//		thread.setDaemon(true);
//		thread2.setDaemon(true);
		thread.start();
		thread2.start();
		
		System.out.println("main end...");

	}

}
