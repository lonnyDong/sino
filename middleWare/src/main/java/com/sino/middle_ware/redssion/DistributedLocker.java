package com.sino.middle_ware.redssion;

public interface DistributedLocker {

	public <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws UnableToAquireLockException,Exception;

	public <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws UnableToAquireLockException,Exception;
	

}