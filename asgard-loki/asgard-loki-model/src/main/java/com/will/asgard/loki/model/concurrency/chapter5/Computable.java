package com.will.asgard.loki.model.concurrency.chapter5;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-10-30 14:54
 * @Version 1.0
 **/
interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
