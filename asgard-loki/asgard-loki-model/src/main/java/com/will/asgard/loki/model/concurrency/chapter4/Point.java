package com.will.asgard.loki.model.concurrency.chapter4;

import javax.annotation.concurrent.Immutable;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-01 9:28 下午
 * @Version 1.0
 */
@Immutable
class Point {
    final int x;
    final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
