package com.will.asgard.loki.model.concurrent.chapter2;

/**
 * @ClassName DaemonDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-27 02:01
 * @Version 1.0
 **/
public class DaemonDemo {
	private static class DaemonT extends Thread {
		@Override
		public void run() {
			System.out.println("I am alive");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new DaemonT();
		t.setDaemon(true);
		t.start();

		Thread.sleep(2000);
	}
}
