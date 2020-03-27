package com.will.asgard.loki.model.concurrent.chapter2;

/**
 * @ClassName PriorityDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-27 02:09
 * @Version 1.0
 **/
public class PriorityDemo {
	private static int countHigh = 0;
	private static int countLow = 0;

	public static void main(String[] args) {
		Thread high = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized (this) {
						countHigh++;
						System.out.println("high: " + countHigh);
					}
					if (countHigh == 50) {
						System.out.println("high yield");
						Thread.yield();
					}

					if (countHigh > 100) {
						System.out.println("High is complete");
						break;
					}
				}
			}
		});
		high.setPriority(Thread.MAX_PRIORITY);

		Thread low = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized (this) {
						System.out.println("low: " + countLow);
						countLow++;
					}
					if (countLow > 100) {
						System.out.println("Low is complete");
						break;
					}
				}
			}
		});
		low.setPriority(Thread.MIN_PRIORITY);

		high.start();
		low.start();
	}
}
