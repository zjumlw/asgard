package com.will.asgard.loki.model.concurrency.chapter8;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import com.will.asgard.common.util.CommonUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 增加了日志和计时功能的线程池
 * @Author maolingwei
 * @Date 2021-02-07 下午2:44
 * @Version 1.0
 */
@Slf4j
public class TimingThreadPool extends ThreadPoolExecutor {

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    private final AtomicLong numTasks = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        log.info("Thread {}: start {}", t, r);
        startTime.set(CommonUtil.getCurrentTimestamp());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long endTime = CommonUtil.getCurrentTimestamp();
            long taskTime = endTime - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            log.info("Thread end {}, time={}", r, taskTime);
        } finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated() {
        try {
            log.info("Terminated: avg time={}", (totalTime.get() / numTasks.get()));
        } finally {
            super.terminated();
        }
    }
}
