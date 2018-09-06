package com.sino.base.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * testMethod这个方法替换为要测试的方法就可以了。如果不需要在所有线程执行完执行某些代码，
 * 可以去掉CountDownLatch的使用；如果不需要控制同一时间同时并行的线程数，可以去掉Semaphore的使用。
 * 
 * @author lonny
 *
 */

public class ConcurrencyTest { // 请求的总数
	public static int clientTotal = 5000;
	// 同时并发执行的线程数
	public static int threadTotal = 200;

	static Logger logger = LoggerFactory.getLogger(ConcurrencyTest.class);

	public static void main(String[] args) throws Exception {

		ExecutorService executorService = Executors.newCachedThreadPool();
		// 信号量,控制同事运行的线程个数
		final Semaphore semaphore = new Semaphore(threadTotal);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i = 0; i < clientTotal; i++) {
			executorService.execute(() -> {
				try {
					semaphore.acquire();
					testMethod();
					semaphore.release();
				} catch (Exception e) {
					logger.error("exception：{}", e);
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executorService.shutdown();
		// 所有线程执行完，之后才能执行的部分
	}

	private static void testMethod() {
		// 待验证的方法

	}

}
