package com.sino.test;

public class TestVolatile {
	public static void main(String[] args) {
		try {
			Thread8 t = new Thread8();
			t.start();
			Thread.sleep(1000);
			t.setRunning(false);
			System.out.println("已赋值false");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Thread8 extends Thread {
	private boolean isRunning = true;

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public void run() {
		System.out.println("进入run()了");
		while (isRunning) {
			System.out.println(System.currentTimeMillis());
		}
		System.out.println("线程被停止了");
	}
}