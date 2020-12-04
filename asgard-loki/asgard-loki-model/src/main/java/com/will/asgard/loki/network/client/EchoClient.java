package com.will.asgard.loki.network.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-12-04 18:56
 * @Version 1.0
 **/
public class EchoClient {

    private Socket socket;

    public EchoClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    public void run() throws IOException {
        Thread thread = new Thread(new ReadTask());
        thread.start();

        OutputStream out = socket.getOutputStream();
        byte[] buffer = new byte[1024];
        int n;
        while ((n = System.in.read(buffer)) > 0) {
            out.write(buffer, 0, n);
        }
    }

    private class ReadTask implements Runnable {

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int n;
                while ((n = in.read(buffer)) > 0) {
                    System.out.write(buffer, 0, n);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        EchoClient client = new EchoClient("localhost", 9877);
        client.run();
    }
}
