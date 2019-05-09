package redislock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LockRegistryDemo {

	public static String GOODS_BALANCE_LOCK = "lock_goods_balance_";


	@Autowired
	RedisLockRegistry redisLockRegistry;
	@Autowired
	RedisTemplate redisTemplate;

	private static AtomicInteger count = new AtomicInteger(0);

	@Test
	public void testLock() {

		ExecutorService pool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			pool.execute(() -> {
				Lock lock = redisLockRegistry.obtain(GOODS_BALANCE_LOCK);
				System.err.println("get lock :" + lock.toString());
				String name = Thread.currentThread().getName();

				try {
					boolean b = lock.tryLock();
					if (b) {
						System.err.println("锁成功:" + name);
					}


				} catch (Exception ex) {
					System.out.println("锁异常：" + ex.getMessage() + name);
				}finally {

					try {
						lock.unlock();
						System.out.println("释放锁成功：" + name);

					} catch (Exception e) {
						System.out.println("释放锁失败：" + e.getMessage() + name);
					}
				}


			});
		}

		while (true) {

		}

	}

	private void repeatedBuy() {

		for (int i = 0; i < 300; i++) {
			goodsChange(Thread.currentThread().getName(), false);
		}

	}

	@Test
	public void test2() {
		while (true) {
			goodsChange(Thread.currentThread().getName(), true);
		}
	}



	@Test
	public void testByGoods() {

		Thread thread = new Thread(() -> {

			for (int i = 0; i < 100; i++) {
				System.out.println("输出次数：" + i);
				goodsChange(Thread.currentThread().getName(), false);
			}
		}, "my thread 001");

		Thread thread2 = new Thread(() -> {

			for (int i = 0; i < 80; i++) {
				System.out.println("输出次数：" + i);
				goodsChange(Thread.currentThread().getName(), true);
			}
		}, "my thread 002");

		thread.start();
		thread2.start();

		while(true){

		}

	}


	/***
	 *
	 *
	 */

	private void goodsChange(String threadName, Boolean type) {
		Lock lock = redisLockRegistry.obtain(GOODS_BALANCE_LOCK);
		String string = lock.toString();
		System.out.println("lock string :" + string);

		try {
			lock.lockInterruptibly();
			if (type) {
				int incrementAndGet = count.incrementAndGet();
				System.out.println(threadName + " +++++" + incrementAndGet);
			} else {
				int incrementAndGet = count.decrementAndGet();
				System.out.println(threadName + " -----" + incrementAndGet);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取锁失败");

		} finally {
			try {
				 lock.unlock();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("解锁失败");
			}
		}

	}




}
