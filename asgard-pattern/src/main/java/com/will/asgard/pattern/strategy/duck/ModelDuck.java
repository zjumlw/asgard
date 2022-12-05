package com.will.asgard.pattern.strategy.duck;

import com.will.asgard.pattern.strategy.duck.impl.FlyNoWay;
import com.will.asgard.pattern.strategy.duck.impl.Quack;

/**
 * @author willmao
 * @date 2022-11-12 15:26
 **/
public class ModelDuck extends Duck {

    public ModelDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck.");
    }
}
