package com.will.asgard.pattern.strategy.duck.impl;

import com.will.asgard.pattern.strategy.duck.FlyBehavior;

/**
 * @author willmao
 * @date 2022-11-12 14:42
 **/
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with wings!");
    }
}
