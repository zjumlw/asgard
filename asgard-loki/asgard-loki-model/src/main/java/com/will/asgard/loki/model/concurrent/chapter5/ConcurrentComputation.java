package com.will.asgard.loki.model.concurrent.chapter5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName ConcurrentComputation
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-13 16:52
 * @Version 1.0
 **/
public class ConcurrentComputation {

	private static class Msg {
		private double i;
		private double j;
		private String orgStr;
	}

	private static class Plus implements Runnable {
		private static BlockingQueue<Msg> blockingQueue = new LinkedBlockingQueue<>();

		@Override
		public void run() {
			for (; ; ) {
				try {
					Msg msg = blockingQueue.take();
					msg.j = msg.i + msg.j;
					Multiply.blockingQueue.add(msg);
				} catch (InterruptedException e) {

				}
			}
		}
	}

	private static class Multiply implements Runnable {
		private static BlockingQueue<Msg> blockingQueue = new LinkedBlockingQueue<>();

		@Override
		public void run() {
			for (; ; ) {
				try {
					Msg msg = blockingQueue.take();
					msg.i = msg.i * msg.j;
					Div.blockingQueue.add(msg);
				} catch (InterruptedException e) {

				}
			}
		}
	}

	private static class Div implements Runnable {
		private static BlockingQueue<Msg> blockingQueue = new LinkedBlockingQueue<>();

		@Override
		public void run() {
			for (; ; ) {
				try {
					Msg msg = blockingQueue.take();
					msg.i = msg.i / 2;
					System.out.println(msg.orgStr + "=" + msg.i);
				} catch (InterruptedException e) {

				}
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new Plus()).start();
		new Thread(new Multiply()).start();
		new Thread(new Div()).start();

		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= 1000; j++) {
				Msg msg = new Msg();
				msg.i = i;
				msg.j = j;
				msg.orgStr = "((" + i + "+" + j + ")*" + i + ")/2";
				Plus.blockingQueue.add(msg);
			}
		}
	}
}
