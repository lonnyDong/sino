package com.sino.base.lock;

public class Account {
	
	private int money=0;
	
	/**
	 * 存钱
	 */
	public void saveMoeny (String threadName) {
		int balance = getBalance();
		balance+=100;
		updateBalance(balance);
		System.out.println(threadName+" 存》》》剩余money:"+balance);
	}
	
	/*
	 * 取钱
	 */
	public  void getMoney(String threadName){
		int balance = getBalance();
		
		if(balance<=0) {
			System.out.println("余额不足,提现失败");
		}else {
			balance -=100;
			updateBalance(balance);
			System.out.println(threadName+ " 取《《《剩余money:"+balance);
		}
		
	}
	
	/**
	 * 获取余额
	 * @return
	 */
	public int getBalance() {
		return money;
	}
	
	/**
	 * 更新余额
	 * @return
	 */
	public void updateBalance(int money) {
		this.money = money;
	}

	
}
