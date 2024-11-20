package com.will.asgard.pattern.strategy.duck;

import com.will.asgard.pattern.strategy.duck.Duck;
import com.will.asgard.pattern.strategy.duck.ModelDuck;
import com.will.asgard.pattern.strategy.duck.impl.FlyRocketPowered;

import org.junit.Test;

/**
 * @author willmao
 * @date 2022-11-12 15:28
 **/
public class ModelDuckTest {

    @Test
    public void test() {
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}