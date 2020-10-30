package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.concurrent.GuardedBy;

/**
 * @Description 相比于 {@link Memoizer1}，用 ConcurrentHashMap 替代了 HashMap，并发调用性能增加；但是对于多线程同时调用
 *   某个大开销计算时，后来的线程最高效的方法是等待前面的线程计算结束，直接去缓存获取，而不是一起同时计算。
 *   特别对于只提供单次初始化的对象缓存来说，这个漏洞会带来安全风险。
 * @Auther maolingwei
 * @Date 2020-10-30 15:50
 * @Version 1.0
 **/
class Memoizer2<A, V> implements Computable<A, V> {

    @GuardedBy("this")
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
