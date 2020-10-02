package com.will.asgard.loki.model.concurrency.chapter4;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-01 8:47 下午
 * @Version 1.0
 */
@NotThreadSafe
class MutablePoint {
    int x;
    int y;

    public MutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MutablePoint(MutablePoint point) {
        this.x = point.x;
        this.y = point.y;
    }
}
