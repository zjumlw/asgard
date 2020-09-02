package com.will.asgard.loki.model.concurrent.myfuture;

/**
 * @ClassName FutureData
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-08-28 14:52
 * @Version 1.0
 **/
public class FutureData<T> {
    private boolean isReady;
    private T data;

    public synchronized void setData(T data) {
        this.data = data;
        isReady = true;
        notifyAll();
    }

    public T getData() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }
}
