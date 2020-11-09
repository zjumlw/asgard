package com.will.asgard.loki.model.concurrency.chapter6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.will.asgard.loki.model.concurrency.ExceptionHandler;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-11-08 1:23 上午
 * @Version 1.0
 */
public class TimedTaskHelper {

    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(5);
    private static final ExecutorService taskExec = Executors.newFixedThreadPool(5);

    public static void timedRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        class RethrowableTask implements Runnable {
            private volatile Throwable  t;

            @Override
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }

            void rethrow() {
                if (t != null) {
                    throw ExceptionHandler.launderThrowable(t);
                }
            }
        }

        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        // 任务开始
        taskThread.start();
        // 取消任务的服务
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        taskThread.join(unit.toMillis(timeout));
        task.rethrow();
    }

    public static void timedRunV2(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        Future<?> task = taskExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {
            // 接下来任务被取消
        } catch (ExecutionException e) {
            // 在任务中抛出了异常，重新抛出异常
            throw ExceptionHandler.launderThrowable(e);
        } finally {
            // 如果任务已经结束，那么执行取消操作也不会带来任何影响
            task.cancel(true); // 如果任务正在执行，那么将被中断
        }
    }
}
