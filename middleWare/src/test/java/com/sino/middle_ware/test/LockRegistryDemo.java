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
	
	@Test
	public void test1() {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {

				for (int i = 0; i < 300; i++) {
					buyGoods(Thread.currentThread().getName());
				}
			}
		};
		
		Thread thread = new Thread(r1);
		thread.setName("TTTTTTLLLLLLLLTTTTTTTT");
		thread.start();
		
	}



	synchronized private void buyGoods(String threadName) {
		RedisLockRegistry redisLockRegistry = RedisLockRegistryConfig.getRedisLockRegistry();
		Lock lock = redisLockRegistry.obtain(GOODS_BALANCE_LOCK);
		try {
			lock.tryLock(100, TimeUnit.MILLISECONDS);
			
			int incrementAndGet = count.incrementAndGet();
			System.out.println(threadName + " TODO...." + incrementAndGet);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取锁失败");

		} finally {
			try {
				lock.unlock();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("解锁失败");
			}
		}

	}
}
