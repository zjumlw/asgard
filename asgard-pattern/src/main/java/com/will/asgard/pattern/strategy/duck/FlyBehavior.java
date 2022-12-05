package com.will.asgard.pattern.strategy.duck;

/**
 * 所有的飞行行为都要实现该类。
 *
 * @author willmao
 * @date 2022-11-12 14:39
 **/
public interface FlyBehavior {

    /**
     * 飞行
     */
    void fly();
}
