package com.sino.base.thread.selfqueue;

public class TestQueue {

	public static void main(String[] args) {
		
		SelfBlockQueue<String> selfBlockQueue = new SelfBlockQueue<String>();
		
		//创建一个生产者 一个消费者
		Producter producter = new Producter();
		Consumer consumer = new Consumer();
		

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int count = 0;
				while(true) {
					count++;
//					String generateNum = producter.generateNum();
					System.out.println("生产的数据："+count);
					
					boolean putLastBlocked = selfBlockQueue.putLastBlocked(count+"");
				}
				
			}
		}).start();
		
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				int count = 0;
				while (true) {
					String first = selfBlockQueue.getFirstBlocked();
					count++;
					consumer.out(first);
				}
			}
		}).start();

	}
	
	
	
	
	
}
