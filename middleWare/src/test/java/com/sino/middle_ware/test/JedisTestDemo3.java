

//package com.sino.middle_ware.test;
//
//import org.apache.commons.lang.StringUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.client.discovery.event.InstanceRegisteredEvent;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.sino.middle_ware.utils.RedisTool;
//
//import redis.clients.jedis.JedisCluster;
//
///**
// * redis分布式锁  
// * @author lonny
// *
// */
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//
//public class JedisTestDemo3 {
//
//	@Autowired
//	JedisCluster jedisCluster;
//
//	public static String GOODS_BALANCE_KEY = "goods_balance_";
//	public static String GOODS_BALANCE_LOCK = "lock_goods_balance";
//
//	/**
//	 * 
//	 * 有线程安全的问题 Thread-6扣减成功，剩余库存1806 Thread-8扣减成功，剩余库存1805 Thread-7扣减成功，剩余库存1805
//	 * Thread-6扣减成功，剩余库存1805 Thread-8扣减成功，剩余库存1804 Thread-7扣减成功，剩余库存1804
//	 * Thread-6扣减成功，剩余库存1804
//	 */
//	@Test
//	public void test1() {
//
//		Runnable r1 = new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 200; i++) {
//					buyGoods(Thread.currentThread().getName());
//				}
//			}
//		};
//		Runnable r2 = new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 200; i++) {
//
//					buyGoods(Thread.currentThread().getName());
//				}
//			}
//		};
//		Runnable r3 = new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 200; i++) {
//
//					buyGoods(Thread.currentThread().getName());
//				}
//			}
//		};
//
//		Thread thread1 = new Thread(r1);
//		Thread thread2 = new Thread(r2);
//		Thread thread3 = new Thread(r3);
//		thread1.start();
//		thread2.start();
//		thread3.start();
//
//	}
//
//	/**
//	 * 下单
//	 */
//	private void buyGoods(String threadName) {
//
//		String str = jedisCluster.get(GOODS_BALANCE_KEY);
//		if (StringUtils.isNotBlank(str)) {
//			Integer balance = Integer.valueOf(str);
//			if (balance >= 10) {
//				balance -= 1;
//				String set = jedisCluster.set(GOODS_BALANCE_KEY, balance + "");
//				if ("OK".equals(set)) {
//					System.out.println(threadName + "扣减成功，剩余库存" + balance);
//				} else {
//					System.out.println(threadName + "扣减库存失败");
//				}
//				return;
//			}
//		}
//
//		System.out.println(threadName + " 库存不足");
//
//	}
//
//}
