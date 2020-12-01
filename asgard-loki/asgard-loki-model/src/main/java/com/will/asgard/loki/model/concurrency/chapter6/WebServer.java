package com.will.asgard.loki.model.concurrency.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-12-01 19:27
 * @Version 1.0
 **/
abstract class WebServer {

    public void handleRequest(Socket connection) {
        try (BufferedReader is = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line = is.readLine();
            System.out.println("receive data from client: " + line);

            PrintWriter pw = new PrintWriter(connection.getOutputStream());
            pw.println("server response data: " + line);
            pw.flush();
            pw.close();

            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
