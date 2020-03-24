package com.will.asgard.loki.model.concurrent;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName StopThreadUnsafe
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-23 22:34
 * @Version 1.0
 **/
public class StopThreadUnsafe {
	public static User u = new User();
	@Getter
	@Setter
	private static class User {
		private int id;
		private String name;
		public User() {
			id = 0;
			name = "0";
		}
		@Override
		public String toString() {
			return String.format("User [id=%d, name=%s]", id, name);
		}
	}

	private static class ChangeObject extends Thread {
		private volatile boolean stopme = false;

		public void stopMe() {
			stopme = true;
		}

		@Override
		public void run() {
			while (true) {
				if (stopme) {
					System.out.println("exit by stop me");
					break;
				}

				synchronized (u) {
					int v = (int) (System.currentTimeMillis() / 1000);
					u.setId(v);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					u.setName(String.valueOf(v));
				}
				Thread.yield();
			}
		}
	}

	private static class ReadObject implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (u) {
					if (u.getId() != Integer.parseInt(u.getName())) {
						System.out.println(u);
					}
				}
				Thread.yield();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		new Thread(new ReadObject()).start();
		while (true) {
			ChangeObject t = new ChangeObject();
			t.start();
			Thread.sleep(150);
			t.stop();
		}
	}


}
