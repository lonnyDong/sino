package com.sino.base.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程执行完后再执行。
 * 例如，应用程序的主线程希望在负责启动框架服务的线程已经启动所有框架服务之后执行
 * @author lonny
 *
 */
public class CountDownLatchTest {

	public static void main(String[] args) {
		//初始计数器的个数为2
		//一定要等到计数器为零主线程才会执行
		CountDownLatch latch = new CountDownLatch(2);
		new Thread(()->{
			try {
				System.out.println("线程1 正在执行");
				Thread.sleep(3000);
				System.out.println("线程1 执行完毕");
				latch.countDown();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}).start(); 
		
		new Thread(()->{
			try {
				System.out.println("线程2 正在执行");
				Thread.sleep(3000);
				System.out.println("线程2 执行完毕");
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start(); 
		
		try {
			System.out.println("等待子线程执行完毕");
//			latch.await();
			latch.await(3000, TimeUnit.MILLISECONDS);//等待时间，过了该时间就不再等待，可以设置所有线程的超时时间
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("子线程执行完毕，主线程继续");
		
		
	}
}
