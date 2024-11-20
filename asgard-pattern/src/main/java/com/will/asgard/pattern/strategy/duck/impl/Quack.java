package com.will.asgard.pattern.strategy.duck.impl;

import com.will.asgard.pattern.strategy.duck.QuackBehavior;

/**
 * @author willmao
 * @date 2022-11-12 14:42
 **/
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack.");
    }
}
