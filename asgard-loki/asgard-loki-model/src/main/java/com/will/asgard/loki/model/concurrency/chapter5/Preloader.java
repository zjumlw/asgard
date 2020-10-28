package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-27 11:03 下午
 * @Version 1.0
 */
public class Preloader {

    private final FutureTask<ProductInfo> future =
            new FutureTask<>(new Callable<ProductInfo>() {
                @Override
                public ProductInfo call() throws Exception {
                    return loadProductInfo();
                }
            });
    private final Thread thread = new Thread(future);

    // 静态方法不好，所以是实例方法，调用一下开始加载info
    public void start() {
        thread.start();
    }

    public ProductInfo get() throws Exception, DataLoadException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            // 检查已知的受检查异常
            if (cause instanceof DataLoadException) {
                // 重新抛出
                throw (DataLoadException) cause;
                // 未检查异常
            } else {
                throw launderThrowable(e);
            }
        }
    }

    private RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        } else if (t instanceof Error) {
            throw (Error) t;
        } else {
            throw new IllegalStateException("Not unchecked", t);
        }
    }

    private ProductInfo loadProductInfo() {
        System.out.println("start load product info");
        ProductInfo info = new ProductInfo();
        info.setName("mi10 pro");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end load product info");
        return info;
    }

    public static void main(String[] args) throws Exception, DataLoadException {
        Preloader preloader = new Preloader();
        preloader.start();

        ProductInfo info = preloader.get();
        System.out.println(info.getName());
    }
}
