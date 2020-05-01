package com.will.asgard.loki.model.jvm.chapter3;

/**
 * @ClassName FinalizeEscapeGC
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-05-01 15:48
 * @Version 1.0
 **/
public class FinalizeEscapeGC {
	private static FinalizeEscapeGC SAVE_HOOK = null;

	private void isAlive() {
		System.out.println("alive");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}

	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinalizeEscapeGC();

		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("dead");
		}

		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("dead");
		}
	}
}
