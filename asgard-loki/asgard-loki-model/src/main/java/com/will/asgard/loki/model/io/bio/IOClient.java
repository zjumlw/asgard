package com.will.asgard.loki.model.io.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @ClassName IOClient
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-16 16:48
 * @Version 1.0
 **/
public class IOClient {

	private static class ClientTask implements Runnable {

		@Override
		public void run() {
			try {
				Socket socket = new Socket("127.0.0.1", 3333);
				while (true) {
					try {
						socket.getOutputStream().write((new Date() + ":hello").getBytes());
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new ClientTask()).start();
	}
}
