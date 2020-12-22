package com.will.asgard.loki.model.concurrency.chapter7;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import javax.annotation.concurrent.GuardedBy;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-11-10 2:34 上午
 * @Version 1.0
 */
public class LogService {
    private static final int CAPACITY = 100;
    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;
    private final PrintWriter writer;
    @GuardedBy("this")
    private boolean isShutdown;
    @GuardedBy("this")
    private int reservations;

    public LogService(PrintWriter writer) {
        this.queue = new LinkedBlockingDeque<>(CAPACITY);
        this.loggerThread = new LoggerThread();
        this.writer = writer;
    }

    public void start() {
        loggerThread.start();
    }

    public void stop() {
        synchronized (this) {
            isShutdown = true;
        }
        loggerThread.interrupt();
    }

    public void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutdown) { // 检测到关闭，不再写入新数据
                throw new IllegalStateException();
            }
            reservations++;
        }
        queue.put(msg);
    }

    private class LoggerThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    try {
                        synchronized (LogService.this) {
                            if (isShutdown && reservations == 0) {
                                break;
                            }
                        }
                        String msg = queue.take();
                        synchronized (LogService.this) { // 保证在队列中的消息被写入日志
                            --reservations;
                        }
                        writer.println(msg);
                    } catch (InterruptedException e) {
                        // retry
                    }
                }
            } finally {
                writer.close();
            }
        }
    }
}
