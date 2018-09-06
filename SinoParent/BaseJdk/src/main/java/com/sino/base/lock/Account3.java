package com.sino.base.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account3 {
	
	private int money=0;
	Lock lock = new ReentrantLock();
	/**
	 * 存钱
	 */
	public void saveMoeny (String threadName) {
		lock.lock();
		try {
			this.money +=100;
			System.out.println(threadName+" 存》》》剩余money:"+money);
			
		} finally {
			lock.unlock();
		}
	}
	
	/*
	 * 取钱
	 */
	 public  void getMoney(String threadName){
		
		lock.lock();
		try {
			if(money<=0) {
				System.out.println("余额不足，不能提现");
			}else {
				this.money -=100;
				System.out.println(threadName+ " 取《《《剩余money:"+money);
			}
			
		} finally {
			lock.unlock();
		}
	}
	
	/**
	 * 获取余额
	 * @return
	 */
	public int getBalance() {
		return money;
	}

	
}
