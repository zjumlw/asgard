package com.will.asgard.loki.model.concurrency.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-30 8:37 下午
 * @Version 1.0
 */
public class LifecycleWebServer extends WebServer {
    private final int nThreads = 100;
    // 3种状态，运行、关闭、中止
    private final ExecutorService exec = Executors.newFixedThreadPool(nThreads);

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(8001);
        while (!exec.isShutdown()) {
            try {
                final Socket conn = socket.accept();
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                        handleRequest(conn);
                    }
                });
            } catch (RejectedExecutionException e) {
                if (!exec.isShutdown()) {
                    System.out.println("task submission rejected");
                }
            }
        }
    }

    public void stop() {
        exec.shutdown();
    }
}
