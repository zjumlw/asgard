package com.will.asgard.loki.model.concurrency.chapter6;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

import javax.annotation.concurrent.GuardedBy;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-11-10 1:41 上午
 * @Version 1.0
 */
public abstract class SocketUsingTask<T> implements CancellableTask<T> {
    @GuardedBy("this")
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void cancel() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ignored) {}
    }

    @Override
    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                try {
                    SocketUsingTask.this.cancel();
                } finally {
                   return super.cancel(mayInterruptIfRunning);
                }
            }
        };
    }
}
