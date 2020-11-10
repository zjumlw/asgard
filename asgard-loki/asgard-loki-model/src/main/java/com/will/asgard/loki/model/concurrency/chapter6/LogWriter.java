package com.will.asgard.loki.model.concurrency.chapter6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-11-10 1:58 上午
 * @Version 1.0
 */
public class LogWriter {
    private static final int CAPACITY = 100;
    private final BlockingQueue<String> queue;
    private final LoggerThread logger; // 日志线程

    public LogWriter(PrintWriter writer) {
        this.queue = new LinkedBlockingDeque<>(CAPACITY);
        this.logger = new LoggerThread(writer);
    }

    public void start() {
        logger.start();
    }

    // 生产
    public void log(String msg) throws InterruptedException {
        queue.put(msg);
    }

    public void flush() {
        logger.flush();
    }

    public void cancel() {
        logger.interrupt();
    }

    private class LoggerThread extends Thread {
        private final PrintWriter writer;

        public LoggerThread(PrintWriter writer) {
            this.writer = writer;
        }

        public void flush() {
            writer.flush();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String msg = queue.take();
                    System.out.println("写入日志: " + msg);
                    writer.println(msg); // 消费
                }
            } catch (InterruptedException ignored) {
                System.out.println("被中断了，退出日志线程");
            } finally {
                writer.close();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String logPath = "/Users/maolingwei/tmp/test.log";
        File logFile = new File(logPath);
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
        PrintWriter writer = new PrintWriter(logFile);
        LogWriter logWriter = new LogWriter(writer);
        logWriter.start();

//        ExecutorService exec = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100000; i++) {
            if (i == 100) {
                logWriter.cancel();
//                break;
            }
            String msg = "msg--" + i;
            logWriter.log(msg);
        }
        logWriter.flush();
    }
}
