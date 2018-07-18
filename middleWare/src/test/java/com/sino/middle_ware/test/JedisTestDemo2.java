/*package com.sino.middle_ware.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.JedisCluster;



@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:application.properties")
public class JedisTestDemo2 {

	@Autowired
	JedisCluster jedisCluster;

	
	private static final String ACCOUNT = "account_";
	

	@Test
	public void test() {
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					saveMoney(Thread.currentThread().getName());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Runnable runnable2 = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					getMoney(Thread.currentThread().getName());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t1 = new Thread(runnable, "线程-1");
		t1.start();
		Thread t2 = new Thread(runnable2, "线程-2");
		t2.start();
		
		
		
		
	}
	
	*//**
	 * 存钱 100
	 *//*
	synchronized  private void   saveMoney(String threadName) {
		
		String money = jedisCluster.get(ACCOUNT);
		if(money!=null) {
			Integer valueOf = Integer.valueOf(money);
			valueOf+= 100;
			jedisCluster.set(ACCOUNT, valueOf+"");
		}else {
			jedisCluster.set(ACCOUNT, "100");
		}
		String string = jedisCluster.get(ACCOUNT);
		System.out.println(threadName+"  存钱后余额:"+string);
	}
	
	
	
	*//**
	 * 取钱
	 *//*
	synchronized  private void getMoney(String threadName) {

		String money = jedisCluster.get(ACCOUNT);
		if (money != null) {
			Integer valueOf = Integer.valueOf(money);
			valueOf -= 100;
			jedisCluster.set(ACCOUNT, valueOf + "");
		}
		String string = jedisCluster.get(ACCOUNT);
		System.out.println(threadName+"  取钱后:"+string);

	}
	
	
}
*/