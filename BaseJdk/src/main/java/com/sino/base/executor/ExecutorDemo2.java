package com.sino.base.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo2 {

	public static void main(String[] args) {
		
		
		/***创建有界的线程池*/
		ExecutorService executorService = new ThreadPoolExecutor(2, 2, 
                0, TimeUnit.SECONDS, 
                new ArrayBlockingQueue<>(512), // 使用有界队列，避免OOM
                new ThreadPoolExecutor.DiscardPolicy());
		
		
		//这种方式不限定队列长度(默认最大长度),有可能导致oom
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		
		
		
	}
	
}
