package com.sino.base.future;

/**
 * CompletableFuture demo
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureDemo {
	public static void main(String[] args) {

		String pdfUrl = new CompletableFutureDemo().getPdfUrl();
		System.out.println(pdfUrl);
	}

	/**
	 * 阻塞获取 等待5秒
	 */
	private String getPdfUrl() {

		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
		new Thread(new Runnable() {
			@Override
			public void run() {
				String url = null;
				int i = 0;
				try {
					while (url == null) {
						System.out.println(i++);
						Thread.sleep(10000);// 10 停10秒
						// 执行操作
						url = "qqq";
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				completableFuture.complete(url);
			}
		}).start();
		// 获取任务结果，如果没有完成会一直阻塞等待
		String result = null;

		try {
			result = completableFuture.get(10, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			completableFuture.completeExceptionally(e);
			e.printStackTrace();
		}

		return result;
	}

}
