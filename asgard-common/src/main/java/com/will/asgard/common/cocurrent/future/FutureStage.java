package com.will.asgard.common.cocurrent.future;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.xiaomi.vip.common.function.Either;
import com.xiaomi.vip.common.util.CommonUtil;

/**
 * Future Manager
 */
public class FutureStage<V> {

	private boolean shutdown;
	private List<Future<V>> jobs;
	private FutureStageOption option;

	private FutureStage() {
		this.shutdown = false;
		this.jobs = Lists.newLinkedList();
	}

	public static <V> FutureStage<V> create() {
		return create(null);
	}

	public static <V> FutureStage<V> create(FutureStageOption option) {
		FutureStageOption opt = option != null ? option : FutureStageOption.normal();

		FutureStage<V> stage = new FutureStage<>();
		stage.option = opt;
		return stage;
	}

	public void shutdown() {
		this.shutdown = true;
	}

	/**
	 * 添加子任务
	 *
	 * @throws NullPointerException if the future is null
	 * @throws RejectedExecutionException if this stage has shut down
	 */
	public void add(Future<V> future) {
		Preconditions.checkNotNull(future);

		if (shutdown) {
			throw new RejectedExecutionException();
		}
		jobs.add(future);
	}

	public List<Either<Throwable, V>> get() {
		return get(option.getEachTimeout(), option.getTotalTimeout());
	}

	/**
	 * 获取执行结果
	 *  调用后无法再添加新任务
	 *
	 * 注意：实际最大等待时间 = 最少等待时间 * 任务数量
	 *
	 * @param eachTime 每个任务的最少等待时间
	 * @param totalTimeout 全部任务的最多等待时间
	 */
	public List<Either<Throwable, V>> get(long eachTime, long totalTimeout) {
		shutdown();

		boolean stageFailed = false;
		long totalTime = totalTimeout > 0 ? totalTimeout : Long.MAX_VALUE;

		List<Either<Throwable, V>> results = Lists.newArrayList();
		for (Future<V> future : jobs) {
			if (stageFailed) {
				cancel(future);
			}

			long startTime = CommonUtil.getCurrentTimestamp();
			long timeout = getTaskTimeout(totalTime, eachTime);
			Either<Throwable, V> either = FutureHelper.get(future, timeout);

			long elapsedTime = CommonUtil.getCurrentTimestamp() - startTime ;
			totalTime -= elapsedTime;

			results.add(either);
			stageFailed = isTotalTimeout(totalTime) || shouldStageFailed(either);
		}

		return results;
	}

	/**
	 * 请求取消任务
	 *  发出中断信号，要求任务能够处理中断
	 *  否则任务可能并不会中止，但无法获取实际执行结果
	 */
	private void cancel(Future<V> future) {
		future.cancel(option.isAbortRunningTask());
	}

	/**
	 * 获取每个任务的等待时间
	 *  由总体剩余时间和最少等待时间共同决定
	 */
	private long getTaskTimeout(long total, long each) {
		if (each <= 0L) {
			return total;
		}
		return each;
	}

	private boolean isTotalTimeout(long totalTime) {
		return totalTime < 0;
	}

	private boolean shouldStageFailed(Either<Throwable, V> either) {
		Preconditions.checkNotNull(either);

		return option.isAbortStageOnError() && either.getLeft().orElse(null) != null;
	}
}
