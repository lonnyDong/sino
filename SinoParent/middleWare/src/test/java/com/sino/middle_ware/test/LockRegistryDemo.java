package com.sino.middle_ware.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sino.middle_ware.config.RedisLockRegistryConfig;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LockRegistryDemo {
	public static String GOODS_BALANCE_LOCK = "lock_goods_balance_1";
	public static String GOODS_BALANCE_KEY = "goods_balance_";
	/* 锁前缀 */
	public static String PERFIX_KEY_OF_LOCK = "lock";

	// @Autowired
	// private LettuceConnectionFactory lettuceConnectionFactory;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	private static AtomicInteger  count = new AtomicInteger(0);
	private static AtomicInteger  count1 = new AtomicInteger(0);
	private static AtomicInteger  count2 = new AtomicInteger(0);
	
	
	private void repeatedBuy() {

		for (int i = 0; i < 300; i++) {
			buyGoods(Thread.currentThread().getName(),false);
		}
		
	}
	
	
	
	@Test
	public void test2() {
		while (true) {
			buyGoods(Thread.currentThread().getName(),true);
		}
	}
	
	
	
	@Test
	public void test1() {

		Thread thread = new Thread(() -> {

			for (int i = 0; i < 600; i++) {
				System.out.println("输出次数：" + i);
				buyGoods(Thread.currentThread().getName(), false);
			}
		}, "my thread 001");

		
		Thread thread2 = new Thread(() -> {

			for (int i = 0; i < 601; i++) {
				System.out.println("输出次数：" + i);
				buyGoods(Thread.currentThread().getName(), true);
			}
		}, "my thread 002");
		
		thread.start();
		thread2.start();

	}

	 private void buyGoods(String threadName,Boolean type) {
		RedisLockRegistry redisLockRegistry = RedisLockRegistryConfig.getRedisLockRegistry();
		Lock lock = redisLockRegistry.obtain(GOODS_BALANCE_LOCK);
		String string = lock.toString();
		System.out.println("lock string :" + string);

		try {
			lock.lockInterruptibly();
			if(type) {
				int incrementAndGet = count.incrementAndGet();
				System.out.println(threadName + " +++++" + incrementAndGet);
			}else {
				int incrementAndGet = count.decrementAndGet();
				System.out.println(threadName + " -----" + incrementAndGet);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取锁失败");

		} finally {
			try {
//				lock.unlock();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("解锁失败");
			}
		}

	}
}
