package com.sino.base.executor;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author lonny
 *
 */
public class ExecutorDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		// ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);//线程池数量为5
		
		ExecutorService executor = Executors.newCachedThreadPool();
		MyRunable myRunable = new MyRunable();
		// 第一种:执行Runable
		executor.submit(myRunable);

		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				String randomString = getRandomString();
				return randomString;
			}
		};

		// 第二种:执行callable
		Future<String> submit = executor.submit(callable);
		// 在指定的时间内获取结果，如果没有
		String res2 = submit.get(1, TimeUnit.SECONDS);
		// 等待方法执行完毕，获取结果
		String res = submit.get();					
		System.out.println(res2 + "||" + res);
		boolean done = submit.isDone();
		if (done) {
			executor.shutdown();
		}

	}
	
	private static String getRandomString() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return UUID.randomUUID().toString();
		
	}
	
	private static void doSomthingElse() {
		
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				
			}
			System.out.println("wathing tv ....");
		}
	}
	
	
	
	
	
}


class MyRunable implements Runnable{

	@Override
	public void run() {
		System.out.println("实现Runnable 接口");
	}
} 
