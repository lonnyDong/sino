package com.sino.base.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForkJoinTaskExample extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;
	public static final int threshold = 2;
	private int start;
	private int end;

	static Logger log = LoggerFactory.getLogger(ForkJoinTaskExample.class);

	public ForkJoinTaskExample(int start, int end) {
		this.start = start;
		this.end = end;
	}

//	对于Fork/Join模式，假如Pool里面线程数量是固定的，那么调用子任务的fork方法相当于A先分工给B，然后A当监工不干活，
//	B去完成A交代的任务。所以上面的模式相当于浪费了一个线程。那么如果使用invokeAll相当于A分工给B后，A和B都去完成工作。
//	这样可以更好的利用线程池，缩短执行的时间
	
	
	@Override
	protected Integer compute() {
		int sum = 0;
		// 如果任务足够小就计算任务
		boolean canCompute = (end - start) <= threshold;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			// 如果任务大于阈值，就分裂成两个子任务计算
			int middle = (start + end) / 2;
			ForkJoinTaskExample leftTask = new ForkJoinTaskExample(start, middle);
			ForkJoinTaskExample rightTask = new ForkJoinTaskExample(middle + 1, end);
			// 执行子任务
//			leftTask.fork();
//			rightTask.fork();
			invokeAll(leftTask, rightTask);
			// 等待任务执行结束合并其结果
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			
			// 合并子任务
			sum = leftResult + rightResult;
		}
		return sum;

	}

	public static void main(String[] args) {
		ForkJoinPool forkjoinPool = new ForkJoinPool();
		// 生成一个计算任务，计算1+2+3+4
		ForkJoinTaskExample task = new ForkJoinTaskExample(1, 100);
		// 执行一个任务
		Future<Integer> result = forkjoinPool.submit(task);
		try {
			log.info("result:{}", result.get());
		} catch (Exception e) {
			log.error("exception", e);
		}

	}
}
