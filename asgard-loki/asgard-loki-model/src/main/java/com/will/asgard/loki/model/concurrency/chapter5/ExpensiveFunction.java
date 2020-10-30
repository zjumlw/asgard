package com.will.asgard.loki.model.concurrency.chapter5;

import java.math.BigInteger;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-10-30 14:55
 * @Version 1.0
 **/
class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        Thread.sleep(1000);
        return new BigInteger(arg);
    }
}
