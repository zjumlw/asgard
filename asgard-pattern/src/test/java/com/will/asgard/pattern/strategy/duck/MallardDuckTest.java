package com.will.asgard.pattern.strategy.duck;

import com.will.asgard.pattern.strategy.duck.Duck;
import com.will.asgard.pattern.strategy.duck.MallardDuck;

import org.junit.Test;

/**
 * @author willmao
 * @date 2022-11-12 14:55
 **/
public class MallardDuckTest {

    @Test
    public void test() {
        Duck duck = new MallardDuck();
        duck.display();
        duck.performFly();
        duck.performQuack();
    }
}