package com.will.asgard.loki.model.concurrency.chapter6;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-11-07 8:57 下午
 * @Version 1.0
 */
public class PrimeGenerator implements Runnable {
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        new Thread(this).start();
        try {
            Thread.sleep(1000);
        } finally {
            this.cancel();
        }
        return this.get();
    }

    public static void main(String[] args) throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        List<BigInteger> ans = generator.aSecondOfPrimes();
        System.out.println(ans.size());
        System.out.println(ans);

        List<BigInteger> ans1 = generator.aSecondOfPrimes();
        System.out.println(ans1);


    }
}
