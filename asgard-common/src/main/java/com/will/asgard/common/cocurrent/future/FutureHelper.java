package com.will.asgard.common.cocurrent.future;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.xiaomi.vip.common.function.Either;
import com.xiaomi.vip.common.function.Functions;
import com.xiaomi.vip.common.util.CommonHelper;

/**
 * Future with Either
 *
 * @author lili10@xiaomi.com
 */
public class FutureHelper {

	private FutureHelper() {
		throw new IllegalStateException();
	}

	public static <V> List<Optional<V>> convert(List<Either<Throwable, V>> result) {
		return CommonHelper.convert(result, either -> {
			if (either == null || either.isLeft()) {
				return Optional.empty();
			}
			return either.getRight();
		});
	}

	public static <V> Either<Throwable, V> get(Future<V> future) {
		return get(future, 0);
	}

	public static <V> Either<Throwable, V> get(Future<V> future, long timeout) {
		if (timeout <= 0) {
			return Functions.lift(future::get);
		}
		return Functions.lift(() -> future.get(timeout, TimeUnit.MILLISECONDS));
	}
}
