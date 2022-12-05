package com.will.asgard.pattern.strategy.duck;

/**
 * 所有的呱呱叫行为都需要实现该类。
 *
 * @author willmao
 * @date 2022-11-12 14:40
 **/
public interface QuackBehavior {

    /**
     * 呱呱叫
     */
    void quack();
}
