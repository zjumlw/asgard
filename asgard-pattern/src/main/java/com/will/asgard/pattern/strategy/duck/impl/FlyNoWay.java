package com.will.asgard.pattern.strategy.duck.impl;

import com.will.asgard.pattern.strategy.duck.FlyBehavior;

/**
 * @author willmao
 * @date 2022-11-12 14:42
 **/
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly.");
    }
}
