package com.sino.base.thread.selfqueue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实现一个阻塞队列 先进先出
 * 
 * @author lonny 如果队列中有数据没有被消费那就等待或者直接丢弃新的任务 如果队列中数据为空 消费就等待被唤醒
 * @param <T>
 *
 *
 */
public class SelfBlockQueue<T> {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/** 默认队列长度 */
	private int DEFAULT_SIZE = 5;

	/** 当前队列长度 */
	private volatile static int QUEUE_INDEX = 0;

	/** 容器 */
	private LinkedList<T> content = new LinkedList<T>();

	ReentrantLock lock = new ReentrantLock();

	private Condition p = lock.newCondition();

	private Condition c = lock.newCondition();

	/**
	 * 直接添加返回是否成功
	 **/
	public boolean putLast(T t) {
		try {
			lock.lock();
			if (QUEUE_INDEX >= DEFAULT_SIZE) {
				return false;
			} else {
				++QUEUE_INDEX;
				content.addLast(t);
				return true;
			}

		} catch (Exception e) {
			return false;
		} finally {
			lock.unlock();
		}

	}

	/**
	 * 直接添加返回是否成功,只要生产成功就提醒消费者可以消费了
	 **/
	public boolean putLastBlocked(T t) {
		lock.lock();
		try {
			int count = 0;

			while (QUEUE_INDEX >= DEFAULT_SIZE) {
				logger.info("队列已满,线程{}等待中...{}", Thread.currentThread().getName(), count);
				++count;
				p.await();
			}

			++QUEUE_INDEX;
			content.addLast(t);
			c.signal();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return false;

	}

	/**
	 * 直接返回
	 **/
	public T getFirst() {
		try {
			lock.lock();

			if (QUEUE_INDEX == 0) {
				logger.info("队列已经被清空", content.isEmpty());
				return null;
			}

			T first = content.getFirst();
			content.removeFirst();
			if (first != null) {
				--QUEUE_INDEX;
				if (QUEUE_INDEX <= 0) {
					QUEUE_INDEX = 0;
				}
				return first;
			} else {
				QUEUE_INDEX = 0;
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

		return null;
	}

	/**
	 * 阻塞获取，只要消费为空就告诉生产者需要生产了
	 * 
	 * @return
	 */
	public T getFirstBlocked() {

		try {
			lock.lock();
			int count = 0;
			while (QUEUE_INDEX <= 0) {
				logger.info("队列为空,线程{}等待中...{}", Thread.currentThread().getName(), ++count);
				Thread.sleep(200);
				c.await();
			}

			T first = content.getFirst();
			content.removeFirst();
			--QUEUE_INDEX;
			p.signal();
			return first;

		} catch (InterruptedException e) {

			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return null;

	}

}
