package com.will.asgard.loki.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-12-04 18:53
 * @Version 1.0
 **/
public class EchoServer {

    private ServerSocket serverSocket;

    public EchoServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void run() throws IOException {
        Socket conn = serverSocket.accept();
        handleConn(conn);
    }

    private void handleConn(Socket conn) throws IOException {
        InputStream in = conn.getInputStream();
        OutputStream out = conn.getOutputStream();
        byte[] buffer = new byte[1024];
        int n;
        while ((n = in.read(buffer)) > 0) {
            out.write(buffer, 0, n);
        }
    }

    public static void main(String[] args) throws IOException {
        EchoServer server = new EchoServer(9877);
        server.run();
    }
}
