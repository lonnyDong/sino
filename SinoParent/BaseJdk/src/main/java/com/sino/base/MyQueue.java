package com.sino.base;

/**
 * 模拟队列操作
 */
public class MyQueue {

	private static final int INITSIZE = 10;
	private int maxSize = 10;
	/**
	 * 头部
	 */
	private volatile int head = 0;
	/**
	 * 尾部
	 */
	private volatile int tail = 0;

	private String[] data;

	public MyQueue(int maxSize) {
		if (maxSize == 0) {
			this.maxSize = INITSIZE;
		} else {
			this.maxSize = maxSize;
		}

		data = new String[this.maxSize];
	}

	public MyQueue() {

	}

	/**
	 * add
	 */
	private boolean add(String arg) {

		if (head > maxSize) {
			throw new RuntimeException("队列已满！");

		}

		data[head] = arg;
		if (++head == maxSize) {
			head = maxSize - 1;
		}

		return true;

	}

	/**
	 * get
	 */
	private String get() {
		String res = null;
		if (head == tail && data[0] == null) {
			throw new RuntimeException("队列已清空");
		}
		res = data[head];
		data[head] = null;
		head--;
		return res;
	}


	public static void main(String[] args) {

		MyQueue myQueue = new MyQueue(5);

		myQueue.add("zhangsan1");
		myQueue.add("zhangsan2");
		myQueue.add("zhangsan3");
		myQueue.add("zhangsan4");
		myQueue.add("zhangsan5");

		for (int i = 0; i <= 5; i++) {
			String s = myQueue.get();
			System.out.println(s);
		}

	}

}
