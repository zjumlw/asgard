package com.will.asgard.loki.model.effective.chapter10;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

import com.will.asgard.common.util.GsonUtil;

import lombok.Data;

/**
 * @ClassName ConcurrentExample
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-17 22:31
 * @Version 1.0
 **/
public class ConcurrentExample {

	private static final ConcurrentMap<String, String> map =
			new ConcurrentHashMap<>();

	public static String intern(String s) {
		String result = map.get(s);
		if (result == null) {
			result = map.putIfAbsent(s, s);
			if (result == null) {
				result = s;
			}
		}
		return result;
	}

	public static void internStatus() {
		System.out.println(GsonUtil.toJson(map));
	}

	public static long time(Executor executor, int concurrency, final Runnable action) throws InterruptedException {
		final CountDownLatch ready = new CountDownLatch(concurrency);
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch done = new CountDownLatch(concurrency);

		for (int i = 0; i < concurrency; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					ready.countDown();
					try {
						start.await();
						action.run();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					} finally {
						done.countDown();
					}
				}
			});
		}

		ready.await();
		long startTime = System.nanoTime();
		start.countDown();
		done.await();
		return System.nanoTime() - startTime;
	}

	@Data
	public static class FieldType {
		private String name;
	}

	private FieldType field;

	synchronized FieldType getField() {
		if (field == null) {
			field = computeFieldType();
		}
		return field;
	}

	private FieldType computeFieldType() {
		System.out.println("computeFieldType");
		FieldType fieldType = new FieldType();
		fieldType.setName("hello");
		return fieldType;
	}


	private static class FieldHolder {
		static final FieldType fieldType = computeFieldValue();
		private static FieldType computeFieldValue() {
			System.out.println("FieldHolder#computeFieldValue");
			FieldType fieldType = new FieldType();
			fieldType.setName("hello world");
			return fieldType;
		}
	}
	public static FieldType getStaticField() {
		return FieldHolder.fieldType;
	}

	private volatile FieldType anotherField;
	public FieldType getAnotherField() {
		FieldType result = anotherField;
		if (result == null) { // first check, no locking
			synchronized (this) {
				result = field;
				if (result == null) { // second check, with locking
					field = result = computeFieldType();
				}
			}
		}
		return result;
	}
}
