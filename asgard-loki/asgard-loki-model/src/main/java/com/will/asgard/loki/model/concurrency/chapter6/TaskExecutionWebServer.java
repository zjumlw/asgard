package com.will.asgard.loki.model.concurrency.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-10-30 17:56
 * @Version 1.0
 **/
class TaskExecutionWebServer extends WebServer {
    private static final int NTHREADS = 100;
    private static final Executor executor = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        TaskExecutionWebServer taskExecutionWebServer = new TaskExecutionWebServer();
        ServerSocket socket = new ServerSocket(8001);
        while (true) {
            // accept是阻塞方法
            final Socket connection = socket.accept();
            Runnable task = () -> taskExecutionWebServer.handleRequest(connection);
            executor.execute(task);
        }
    }
}
