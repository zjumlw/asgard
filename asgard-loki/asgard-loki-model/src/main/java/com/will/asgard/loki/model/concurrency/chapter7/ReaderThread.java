package com.will.asgard.loki.model.concurrency.chapter7;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-11-10 12:12 上午
 * @Version 1.0
 */
public class ReaderThread extends Thread {
    private final Socket socket;
    private final InputStream in;

    public ReaderThread(Socket socket, InputStream in) {
        this.socket = socket;
        this.in = in;
    }

    @Override
    public void interrupt() {
        try {
            socket.close();
        } catch (IOException ignored) {

        } finally {
            super.interrupt();
        }
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[1024];
            while (true) {
                int count = in.read(buf);
                if (count <= 0) {
                    break;
                } else {
                    processBuffer(buf, count);
                }
            }
        } catch (IOException e) {
            // 允许线程退出
        }
    }

    private void processBuffer(byte[] buf, int count) {

    }
}
