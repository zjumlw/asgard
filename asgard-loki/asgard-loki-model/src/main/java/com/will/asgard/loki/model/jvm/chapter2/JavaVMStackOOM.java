package com.will.asgard.loki.model.jvm.chapter2;

/**
 * @ClassName JavaVMStackOOM
 * @Description VM Args: -Xss2M
 * @Author maolingwei
 * @Date 2020-05-01 14:38
 * @Version 1.0
 **/
public class JavaVMStackOOM {

	public static void main(String[] args) {
		new JavaVMStackOOM().stackLeakByThread();
	}

	private void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	private void dontStop() {
		while (true) {

		}
	}


}
