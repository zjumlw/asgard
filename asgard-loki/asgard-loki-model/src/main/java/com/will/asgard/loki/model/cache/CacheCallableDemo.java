package com.will.asgard.loki.model.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @ClassName CacheCallableDemo
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-16 15:25
 * @Version 1.0
 **/
public class CacheCallableDemo {
	public static void main(String[] args) throws ExecutionException {
		Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(100).build();
		String value = cache.get("test", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "test-value";
			}
		});

		System.out.println(value);
	}
}
