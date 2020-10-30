package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.concurrent.GuardedBy;

/**
 * @Description 用HashMap缓存计算结果，由于对整个compute方法加上了同步，所以可伸缩性差，并发性糟糕
 * @Auther maolingwei
 * @Date 2020-10-30 14:56
 * @Version 1.0
 **/
class Memoizer1<A, V> implements Computable<A, V> {

    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
