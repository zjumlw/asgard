package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicBarrierDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-07 19:00
 * @Version 1.0
 **/
public class CyclicBarrierDemo {
	private static class Soldier implements Runnable {
		private String soldier;
		private final CyclicBarrier cyclicBarrier;

		public Soldier(String soldier, CyclicBarrier cyclicBarrier) {
			this.soldier = soldier;
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			try {
				cyclicBarrier.await();
				doWork();
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

		private void doWork() {
			try {
				Thread.sleep(new Random().nextInt(10) * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(soldier + " mission complete");
		}
	}

	private static class BarrierRun implements Runnable {
		private boolean flag;
		private int N;

		public BarrierRun(boolean flag, int n) {
			this.flag = flag;
			N = n;
		}

		@Override
		public void run() {
			if (flag) {
				System.out.println(N + " soldiers complete mission");
			} else {
				System.out.println(N + " soldiers arrived");
				flag = true;
			}
		}
	}

	public static void main(String[] args) {
		final int N = 10;
		Thread[] allSoldiers = new Thread[N];
		boolean flag = false;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));

		System.out.println("Together");

		for (int i = 0; i < N; i++) {
			System.out.println("Soldier " + i + " arrived");
			allSoldiers[i] = new Thread(new Soldier("Soldier" + i, cyclicBarrier));
			allSoldiers[i].start();
		}
	}
}
