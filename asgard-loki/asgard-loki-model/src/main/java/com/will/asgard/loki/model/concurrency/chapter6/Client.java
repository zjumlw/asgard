package com.will.asgard.loki.model.concurrency.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-10-30 18:05
 * @Version 1.0
 **/
public class Client {

    public static void main(String[] args) throws IOException {
        String msg = "client data";

        try {
            int times = 10;
            for (int i = 0; i < times; i++) {
                Socket socket = new Socket("127.0.0.1", 8001);
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                pw.println(msg + "-" + i);
                pw.flush();

                BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = is.readLine();
                System.out.println("received from server: " + line);
            }

//            pw.close();
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
