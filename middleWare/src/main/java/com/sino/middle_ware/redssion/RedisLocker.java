/*package com.sino.middle_ware.redssion;

import java.util.concurrent.TimeUnit;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisLocker implements DistributedLocker {

	private final static String LOCKER_PREFIX = "lock:";

	@Autowired
	private RedissonClient redissonClient;

	@Override
	public <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws InterruptedException, Exception {

		return lock(resourceName, worker, 100);
	}

	@Override
	public <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws UnableToAquireLockException,Exception {

		RLock lock = redissonClient.getLock(LOCKER_PREFIX + resourceName);

		boolean success = lock.tryLock(20, lockTime, TimeUnit.SECONDS);
		
		if (success) {
			try {
				return worker.invokeAfterLockAquire();
			} finally {
				if(lock.isLocked()) {
					lock.unlock();
				}
			}
		}
		throw new UnableToAquireLockException();
	}
}*/