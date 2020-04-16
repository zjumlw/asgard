package com.will.asgard.loki.model.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * @ClassName CacheDemo
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-15 16:38
 * @Version 1.0
 **/
public class CacheDemo {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
				.concurrencyLevel(8)
				.expireAfterAccess(5, TimeUnit.SECONDS)
				.initialCapacity(10)
				.maximumSize(100)
				.recordStats()
				.removalListener(new RemovalListener<Object, Object>() {
					@Override
					public void onRemoval(RemovalNotification<Object, Object> notification) {
						System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
					}
				}).build(new CacheLoader<Integer, String>() {
					@Override
					public String load(Integer key) throws Exception {
						System.out.println("load data: " + key);
						return key + ":cache-value";
					}
				});

		for (int i = 0; i < 20; i++) {
			String str = cache.get(i);
			System.out.println(str);
			Thread.sleep(500);
		}

		System.out.println("cache stats: ");
		System.out.println(cache.stats().toString());
	}
}
