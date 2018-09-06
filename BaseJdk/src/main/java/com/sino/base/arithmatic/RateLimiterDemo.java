package com.sino.base.arithmatic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 令牌桶算法 RateLimiter实现
 * 
 * @author lonny
 *
 */
public class RateLimiterDemo {

	@Autowired
	public static void main(String[] args) {
		test2();
		
		
	}

	static RateLimiter limiter = RateLimiter.create(2.0);

	private  static void test2() {
		for (int i = 0; i < 20; i++) {
			long start = System.currentTimeMillis();
			String userByFeignBatchDelay = getUserByFeignBatchDelay();
			System.out.println("降级：" + userByFeignBatchDelay);
			long end = System.currentTimeMillis();
			System.out.println((end - start) + "ms");
		}
	}

	private static void test1() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

		// 线程池执行20个任务
		for (int i = 0; i < 20; i++) {

			Callable<String> callable = new Callable<String>() {
				@Override
				public String call() throws Exception {
					String userByFeignBatch = getUserByFeignBatch();
					return userByFeignBatch;
				}
			};

			Future<String> futureTask = cachedThreadPool.submit(callable);

			try {
				String string = futureTask.get(100, TimeUnit.MILLISECONDS);// 100ms内获取结果

				System.out.println("执行结果" + string);
			} catch (InterruptedException e) {
				System.out.println("任务中断异常");
			} catch (ExecutionException e) {
				System.out.println("执行任务出错");
			} catch (TimeoutException e) {
				System.out.println("执行任务超时");
			}
		}
		cachedThreadPool.shutdown();
	}

	/**
	 * limiter.acquire()获取令牌
	 * 
	 * @return
	 */
	public static String getUserByFeignBatch() {

		long start = System.currentTimeMillis();
		double acquire = limiter.acquire();// 获取令牌
		System.out.println("请求获取令牌成功!,消耗=" + acquire);

		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
		return "OK";

	}

	/**
	 * limiter.acquire()获取令牌
	 * 
	 * @return
	 */
	public static String getUserByFeignBatchDelay() {

		// 在指定ms内是否可以获得令牌，如果不能获得直接返回用户失败，不需要阻塞，这里并不是真正的等待了timeout时间，
		// 而是被判断为即便过了timeout时间，也无法取得令牌。这个是不需要等待的。
		// 判断结果为true的不需要再次调用的 acquire()方法
		
		boolean tryAcquire = limiter.tryAcquire(450, TimeUnit.MILLISECONDS);
		if (!tryAcquire) {
			return "false";
		}
	
		return "OK";

	}
}
