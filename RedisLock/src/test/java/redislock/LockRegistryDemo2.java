package redislock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LockRegistryDemo2 {
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	public static String GOODS_BALANCE_LOCK = "lock_goods_balance_";
	public static String GOODS_BALANCE_KEY = "goods_balance_";
	/* 锁前缀 */
	public static String PERFIX_KEY_OF_LOCK = "lock";

	@Autowired
	RedisLockRegistry redisLockRegistry;
	@Autowired
	RedisTemplate redisTemplate;

	private static AtomicInteger count = new AtomicInteger(0);

	@Test
	public void testLock() {

		Lock lock = redisLockRegistry.obtain(GOODS_BALANCE_LOCK);
		LOGGER.info("lock:"+lock);
		{
			try {
				lock.lock();
				LOGGER.info("Lock {} is obtained", lock);
				Thread.sleep(5000);
				lock.unlock();
				LOGGER.info("Lock {} is unlocked", lock);
			} catch (Exception ex) {
				LOGGER.error("Lock {} unlock failed", lock, ex);
			}
		}


	}
	@Test
	public void testLock2() {

		Lock lock = redisLockRegistry.obtain(GOODS_BALANCE_LOCK);
		LOGGER.info("lock:"+lock);
		{
			try {
				lock.lock();
				LOGGER.info("Lock {} is obtained", lock);
				Thread.sleep(5000);








				lock.unlock();
				LOGGER.info("Lock {} is unlocked", lock);
			} catch (Exception ex) {
				LOGGER.error("Lock {} unlock failed", lock, ex);
			}
		}


	}





	@Test
	public void testLock3() {
		String aa = "redis_version:4.0.11".split("\\.")[0];
		System.out.println("aa:"+aa);
	}

}
