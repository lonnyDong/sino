package com.sino.middle_ware.redssion;
/**
 * 获取锁后需要处理的逻辑
 * @author lonny
 * @param <T>
 */
public interface AquiredLockWorker<T> {
	
	public T invokeAfterLockAquire() throws UnableToAquireLockException,Exception;
	
}