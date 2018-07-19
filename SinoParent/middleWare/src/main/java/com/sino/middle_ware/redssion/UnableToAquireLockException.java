package com.sino.middle_ware.redssion;

/**
 * 获取锁失败异常
 * @author lonny
 *
 */
public class UnableToAquireLockException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnableToAquireLockException() {
	}

	public UnableToAquireLockException(String message) {
		super(message);
	}

	public UnableToAquireLockException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}