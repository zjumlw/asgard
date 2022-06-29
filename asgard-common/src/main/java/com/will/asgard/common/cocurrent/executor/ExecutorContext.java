package com.will.asgard.common.cocurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Wither;

/**
 * Environment for ExecutorCallable
 *
 * @see com.xiaomi.vip.common.cocurrent.executor.ExecutorCallable
 */
@Getter
@Setter
@Wither
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExecutorContext {

	private static final int MAX_POOL_SIZE = 32;
	private static final long KEEP_ALIVE_TIME = 5L;
	private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

	// 默认重试次数，多试无益
	private static final int DEFAULT_RETRY_COUNT = 2;

	// 默认线程池，队列无上限
	private static final ExecutorService DEFAULT_THREAD_POOL = newLimitedThreadPool();

	private int retryCount;
	private ExecutorService executorService;
	private ErrorHandler errorHandler;

	public static ExecutorContext normal() {
		return new ExecutorContext()
				.withRetryCount(1)
				.withExecutorService(DEFAULT_THREAD_POOL);
	}

	public static ExecutorContext retry() {
		return normal().withRetryCount(DEFAULT_RETRY_COUNT);
	}

	private static ExecutorService newLimitedThreadPool() {
		// 可继续完善线程创建及拒绝策略的监控
		ThreadPoolExecutor pool = new ThreadPoolExecutor(MAX_POOL_SIZE, MAX_POOL_SIZE,
				KEEP_ALIVE_TIME, TIME_UNIT, new LinkedBlockingQueue<>());
		// 可回收核心线程
		pool.allowCoreThreadTimeOut(true);

		return pool;
	}
}
