package com.will.asgard.loki.model.concurrency.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-12-01 14:52
 * @Version 1.0
 **/
public class SingleThreadWebServer extends WebServer {

    public static void main(String[] args) throws IOException {
        SingleThreadWebServer singleThreadWebServer = new SingleThreadWebServer();

        ServerSocket serverSocket = new ServerSocket(8001);
        while (true) {
            Socket connection = serverSocket.accept();
            singleThreadWebServer.handleRequest(connection);
        }
    }
}
