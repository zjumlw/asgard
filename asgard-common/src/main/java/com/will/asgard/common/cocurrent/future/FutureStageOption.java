package com.will.asgard.common.cocurrent.future;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Wither;

@Getter
@Setter
@Wither
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FutureStageOption {

	private static final long DEFAULT_TIMEOUT_EACH = 200L;

	private long eachTimeout;
	private long totalTimeout;

	// 中止正在执行的任务
	private boolean abortRunningTask;
	// 发生错误则中止
	private boolean abortStageOnError;

	public static FutureStageOption normal() {
		return new FutureStageOption()
				.withEachTimeout(0L)
				.withTotalTimeout(0L)
				.withAbortRunningTask(false)
				.withAbortStageOnError(false);
	}

	public static FutureStageOption timeout() {
		return normal().withEachTimeout(DEFAULT_TIMEOUT_EACH);
	}
}
