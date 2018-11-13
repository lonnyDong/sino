package com.sino.base.thread.selfqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * 多个生产者 多个消费者
 * @author lonny
 *
 */
public class TestQueue2 {

	public static void main(String[] args) {
		
		SelfBlockQueue<String> selfBlockQueue = new SelfBlockQueue<String>();
		
		//创建一个生产者 一个消费者
		Producter producter = new Producter();
		Consumer consumer = new Consumer();
		
		
		ExecutorService pPool = Executors.newFixedThreadPool(4);
		ExecutorService cPool = Executors.newFixedThreadPool(4);
		for(int i=0;i<=2;i++) {
			pPool.execute(()->{
				int count = 0;
				while(true) {
					count++;
//					String generateNum = producter.generateNum();
					System.out.println("生产的数据："+Thread.currentThread().getName()+"【"+count+"】");
					
					boolean putLastBlocked = selfBlockQueue.putLastBlocked(count+"");
				}

			});
		}
		
		for (int i = 0; i <= 2; i++) {
			pPool.execute(() -> {

				while (true) {
					String first = selfBlockQueue.getFirstBlocked();
					consumer.out(first);
				}
			});
		}
		

	}
	
	
	
	
	
}
