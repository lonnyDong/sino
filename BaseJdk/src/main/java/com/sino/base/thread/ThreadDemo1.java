package com.sino.base.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo1 {

	public static void main(String[] args) {

		System.out.println("main start");

		ExecutorService fix = Executors.newFixedThreadPool(3);
		fix.execute(new Runnable() {

			@Override
			public void run() {

				while (true) {
//					System.out.println(Thread.currentThread().getName());
					System.out.println(Thread.currentThread().isDaemon());
				}

			}
		});

		System.out.println("main end...");

	}

}
