package com.will.asgard.loki.model.concurrency.chapter4;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-04 9:33 下午
 * @Version 1.0
 */
@ThreadSafe
class SafePoint {
    @GuardedBy("this")
    private int x;
    @GuardedBy("this")
    private int y;

    public SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    // 拷贝构造函数，避免竞态条件
    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 返回数组，保证数值的一致性
    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
