package com.sino.base.lock;

/**
 * synchronized and ReentrantLock
 *
 * @author lonny
 */
public class LockTestDemo1 {
	 Account  account = new Account();
	 Account2 account2 = new Account2();
	 Account3 account3 = new Account3();

	public static void main(String[] args) {
		LockTestDemo1 lock = new LockTestDemo1();
		
//		lock.withReentLock();
		lock.withoutLock();
//		lock.withSync();
		lock.outPutBalance();
	}

	private void outPutBalance() {
		while (true) {
			System.out.println(account.getBalance());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	/**
	 * 存钱
	 */
	private  void saveMoney() {
		for (int i = 0; i < 100; i++) {

			account.saveMoeny(Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 取钱
	 */
	private  void getMoney() {
		for (int i = 0; i < 100; i++) {

			account.getMoney(Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 存钱
	 */
	private  void saveMoney2() {
		for (int i = 0; i < 100; i++) {

			account2.saveMoeny(Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 取钱
	 */
	private  void getMoney2() {
		for (int i = 0; i < 100; i++) {

			account2.getMoney(Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 存钱
	 */
	private  void saveMoney3() {
		for (int i = 0; i < 100; i++) {

			account3.saveMoeny(Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 取钱
	 */
	private  void getMoney3() {
		for (int i = 0; i < 100; i++) {

			account3.getMoney(Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private  void withReentLock() {

		Thread thread = new Thread(this::saveMoney3);
		thread.start();

		Thread thread2 = new Thread(this::getMoney3);
		thread2.start();

	}

	/**
	 * 同步
	 */
	public  void withSync() {

		Thread thread = new Thread(this::saveMoney2);
		thread.start();

		Thread thread2 = new Thread(this::getMoney2);
		thread2.start();
	}

	/**
	 * 不加锁
	 */
	public  void withoutLock() {

		Thread thread = new Thread(this::saveMoney);
		thread.start();

		Thread thread2 = new Thread(this::getMoney);
		thread2.start();

	}

}
