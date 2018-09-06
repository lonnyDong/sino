package com.sino.base.lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;



/*
 *Stream 与ForkJoin
 */
public class ForkJoinTest {

	

	    /** 
	     * 计算某数到某数的和，返回结果"和" 
	     */  
	    private static class Demo1 extends RecursiveTask<Integer> {  
	        private int start;  
	        private int end;  
	  
	        public Demo1(int start, int end) {  
	            this.start = start;  
	            this.end = end;  
	        }  
	  
	        //计算  
	        @Override  
	        protected Integer compute() {  
	            int sum = 0;  
	            if (start - end < 100) {  
	                for (int i = start; i < end; i++) {  
	                    sum += i;  
	                }  
	            } else {//间隔有100则拆分多个任务计算  
	                int middle = (start + end) / 2;  
	                Demo1 left = new Demo1(start, middle);  
	                Demo1 right = new Demo1(middle + 1, end);  
	                left.fork();  
	                right.fork();  
	  
	                sum = left.join() + right.join();  
	            }  
	            return sum;  
	        }  
	    }  
	  
	    public static void main(String[] args) throws Exception {  
	    	
	    	
	    	
	        ForkJoinPool forkJoinPool = new ForkJoinPool();//对线程池的扩展  
	        ForkJoinTask<String> submit = forkJoinPool.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					
					return null;
				}
			}); 
	        submit.isDone();
	        submit.get();
	        System.out.println(submit.get());  
	    }  
	  
	}  