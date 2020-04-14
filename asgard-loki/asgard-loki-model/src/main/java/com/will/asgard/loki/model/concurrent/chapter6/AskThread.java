package com.will.asgard.loki.model.concurrent.chapter6;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName AskThread
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-14 00:57
 * @Version 1.0
 **/
public class AskThread implements Runnable {
	private CompletableFuture<Integer> re;

	public AskThread(CompletableFuture<Integer> re) {
		this.re = re;
	}

	@Override
	public void run() {
		int myRe = 0;
		try {
			myRe = re.get() * re.get();
		} catch (Exception e) {
		}
		System.out.println("result: " + myRe);
	}

	public static void main(String[] args) throws InterruptedException {
		final CompletableFuture<Integer> future = new CompletableFuture<>();
		new Thread(new AskThread(future)).start();
		Thread.sleep(1000);
		future.complete(60);
	}
}
