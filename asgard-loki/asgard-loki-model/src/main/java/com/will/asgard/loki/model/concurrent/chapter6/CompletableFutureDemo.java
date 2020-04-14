package com.will.asgard.loki.model.concurrent.chapter6;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName CompletableFutureDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-14 01:03
 * @Version 1.0
 **/
public class CompletableFutureDemo {

	private static Integer calc(Integer para) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		return para * para;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		final CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> calc(50))
				.thenApply(i -> Integer.toString(i))
				.thenApply(str->"\""+str+"\"")
				.thenAccept(System.out::println);

		future.get();
	}
}
