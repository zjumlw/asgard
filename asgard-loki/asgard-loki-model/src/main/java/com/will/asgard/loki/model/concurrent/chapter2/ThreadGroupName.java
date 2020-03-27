package com.will.asgard.loki.model.concurrent.chapter2;

/**
 * @ClassName ThreadGroupName
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-27 01:55
 * @Version 1.0
 **/
public class ThreadGroupName implements Runnable {
	@Override
	public void run() {
		String groupAndName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
		while (true) {
			System.out.println("I am " + groupAndName);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("printgroup");
		Thread t1 = new Thread(threadGroup, new ThreadGroupName(), "t1");
		Thread t2 = new Thread(threadGroup, new ThreadGroupName(), "t2");

		t1.start();
		t2.start();
		System.out.println(threadGroup.activeCount());

		threadGroup.list();
	}
}
