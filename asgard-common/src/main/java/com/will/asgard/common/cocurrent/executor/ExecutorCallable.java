package com.will.asgard.common.cocurrent.executor;

import javax.annotation.Nonnull;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.google.common.base.Preconditions;
import com.xiaomi.vip.common.batch.ExecutorWithRetry;
import com.xiaomi.vip.common.util.CommonHelper;

import lombok.Getter;
import lombok.Setter;

/**
 * Callable Enhancer
 *  with retry
 *  with stack trace
 *  with executor service
 *
 * @see com.xiaomi.vip.common.cocurrent.future.FutureStage
 * @see com.xiaomi.vip.common.cocurrent.future.FutureStageOption
 *
 * @author lili10@xiaomi.com
 */
public class ExecutorCallable<V> implements Callable<V> {

	private static final String DEFAULT_THREAD_TAG = "ExecutorCallable";

	@Getter
	@Setter
	private String tag;

	private Callable<V> callable;
	private Exception trace;

	@Getter
	private ExecutorContext executorContext;

	private ExecutorCallable() {
		this.tag = DEFAULT_THREAD_TAG;
	}

	public static <V> ExecutorCallable<V> create(Callable<V> callable) {
		return create(callable, null, null);
	}

	public static <V> ExecutorCallable<V> create(Callable<V> callable, Exception trace) {
		return create(callable, trace, null);
	}

	public static <V> ExecutorCallable<V> create(Callable<V> callable,
			ExecutorService executorService) {
		Preconditions.checkNotNull(callable);
		Preconditions.checkNotNull(executorService);

		ExecutorCallable<V> exCallable = create(callable, null, null);

		ExecutorContext context = exCallable.getExecutorContext();
		context.setExecutorService(executorService);

		return exCallable;
	}

	public static <V> ExecutorCallable<V> create(Callable<V> callable,
			ExecutorContext context) {
		return create(callable, null, context);
	}

	@Nonnull
	public static <V> ExecutorCallable<V> create(Callable<V> callable, Exception trace,
			ExecutorContext context) {
		Preconditions.checkNotNull(callable);

		Exception stack = trace != null ? trace : createStackTrace();
		ExecutorContext ctx = context != null ? context : ExecutorContext.normal();

		if (stack.getCause() != null) {
			throw new IllegalArgumentException("trace's cause must be null");
		}

		ExecutorCallable<V> traceable = new ExecutorCallable<>();
		traceable.trace = stack;
		traceable.callable = callable;
		traceable.executorContext = ctx;

		return traceable;
	}

	@Override
	public V call() throws Exception {
		try {
			// 默认不重试，这个东西对线程池不是很友好
			ExecutorWithRetry<V> executor = new ExecutorWithRetry<>(
					() -> callable.call(),
					wrap(executorContext.getErrorHandler()),
					executorContext.getRetryCount());

			return CommonHelper.executeWithPerf("retry-total for " + tag,
					() -> executor.execute(tag));

		} catch (Throwable th) {
			// 包装异常
			assert trace != null;
			trace.initCause(new RetryFailedException("execute failed", th));
			throw trace;
		}
	}

	public Future<V> async() {
		ExecutorService executor = executorContext.getExecutorService();

		FutureTask<V> future = new FutureTask<>(this);
		executor.execute(future);

		return future;
	}

	/**
	 * 默认上下文
	 *  保存当前堆栈
	 */
	private static Exception createStackTrace() {
		return new StackTraceException();
	}

	/**
	 * 包装异常处理器
	 *  兼容老旧代码
	 */
	private ExecutorWithRetry.OnErrorApi wrap(ErrorHandler handler) {
		return (retryIndex, th) -> {
			if (handler != null) {
				handler.onError(th);
			}
		};
	}

	public ExecutorCallable<V> withTag(String name) {
		setTag(name);
		return this;
	}
}
