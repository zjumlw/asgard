package com.will.asgard.common.cocurrent.executor;

/**
 * 重试最终失败异常
 */
public class RetryFailedException extends Exception {

	public RetryFailedException() {
		super();
	}

	public RetryFailedException(String message) {
		super(message);
	}

	public RetryFailedException(String message, Throwable cause) {
		super(message, cause);
	}
}
