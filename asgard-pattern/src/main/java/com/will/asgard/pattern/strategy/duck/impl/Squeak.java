package com.will.asgard.pattern.strategy.duck.impl;

import com.will.asgard.pattern.strategy.duck.QuackBehavior;

/**
 * @author willmao
 * @date 2022-11-12 14:43
 **/
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
