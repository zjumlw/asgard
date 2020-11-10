package com.will.asgard.loki.model.concurrency.chapter6;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-11-10 1:35 上午
 * @Version 1.0
 */
public interface CancellableTask<T> extends Callable<T> {
    void cancel();
    RunnableFuture<T> newTask();
}
