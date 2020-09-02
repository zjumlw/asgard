package com.will.asgard.loki.model.concurrent.myfuture;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadPoolExecutorDemo
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-08-28 19:05
 * @Version 1.0
 **/
public class ThreadPoolExecutorDemo {

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    /*
     * Bit field accessors that don't require unpacking ctl.
     * These depend on the bit layout and on workerCount being never negative.
     */

    private static boolean runStateLessThan(int c, int s) {
        return c < s;
    }

    private static boolean runStateAtLeast(int c, int s) {
        return c >= s;
    }

    private static boolean isRunning(int c) {
        return c < SHUTDOWN;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(STOP));
        System.out.println(Integer.numberOfLeadingZeros(STOP));
        System.out.println(Integer.numberOfTrailingZeros(STOP));
    }
}
