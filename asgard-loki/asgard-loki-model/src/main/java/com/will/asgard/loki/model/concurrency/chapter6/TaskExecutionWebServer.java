package com.will.asgard.loki.model.concurrency.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
class TaskExecutionWebServer {
    private static final int NTHREADS = 100;
    private static final Executor executor = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8001);
        while (true) {
            // accept是阻塞方法
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            executor.execute(task);
        }
    }

    private static void handleRequest(Socket connection) {
        try (BufferedReader is = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line = is.readLine();
            System.out.println("received from client: " + line);

            PrintWriter pw = new PrintWriter(connection.getOutputStream());
            pw.println("got data: " + line);
            pw.flush();
            pw.close();

            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
