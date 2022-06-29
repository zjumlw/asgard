package com.will.asgard.common.cocurrent.executor;

/**
 * ErrorHandler for ExecutorCallable
 *
 * @see com.xiaomi.vip.common.cocurrent.executor.ExecutorCallable
 */
@FunctionalInterface
public interface ErrorHandler {

	void onError(Throwable th);
}
