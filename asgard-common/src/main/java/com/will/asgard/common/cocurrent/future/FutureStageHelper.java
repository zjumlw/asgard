package com.will.asgard.common.cocurrent.future;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.xiaomi.vip.common.cocurrent.executor.ExecutorCallable;
import com.xiaomi.vip.common.function.Either;
import com.xiaomi.vip.common.function.Lambda;
import com.xiaomi.vip.common.function.VipFunction;
import com.xiaomi.vip.common.util.CommonUtil;

/**
 * Created by WillMao on 19-7-2
 */
public class FutureStageHelper {

	private FutureStageHelper() {
		throw new IllegalStateException();
	}

	public static <T, R> void addFutureBySegment(FutureStage<List<R>> stage, List<T> source,
			VipFunction<List<T>, List<R>> function, int segment) {

		if (CommonUtil.isNullOrEmpty(source)) {
			return;
		}

		int fromIndex = 0;
		while (fromIndex < source.size()) {
			int toIndex = fromIndex + segment;
			if (toIndex > source.size()) {
				toIndex = source.size();
			}

			List<T> subList = source.subList(fromIndex, toIndex);
			addFuture(stage, subList, function);

			fromIndex += segment;
		}
	}

	public static <T, R> void addFuture(FutureStage<R> stage, T source, VipFunction<T, R> function) {
		stage.add(ExecutorCallable.create(Lambda.wrapToCallable(() -> function.apply(source)))
				.async());
	}

	public static <V> List<Throwable> getLeft(FutureStage<V> stage) {
		return stage.get().stream()
				.filter(Either::isLeft)
				.map(Either::getLeft)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());
	}

	public static <V> List<V> getRight(FutureStage<V> stage) {
		return stage.get().stream()
				.filter(Either::isRight)
				.map(Either::getRight)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());
	}

}
