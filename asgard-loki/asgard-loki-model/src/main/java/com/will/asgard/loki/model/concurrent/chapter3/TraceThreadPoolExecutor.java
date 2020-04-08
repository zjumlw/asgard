package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TraceThreadPoolExecutor
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-08 12:01
 * @Version 1.0
 **/
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {
	public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	public void execute(Runnable command) {
		super.execute(wrap(command, clientTrace(), Thread.currentThread().getName()));
	}

	@Override
	public Future<?> submit(Runnable task) {
		return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
	}

	private Exception clientTrace() {
		return new Exception("Client stack trace");
	}

	private Runnable wrap(Runnable task, Exception clientStack, String clientThreadName) {
		return () -> {
			try {
				task.run();
			} catch (Exception e) {
				clientStack.setStackTrace(e.getStackTrace());
				clientStack.printStackTrace();
				throw e;
			}
		};
	}
}
