package com.will.asgard.pattern.strategy.duck;

import com.will.asgard.pattern.strategy.duck.impl.FlyWithWings;
import com.will.asgard.pattern.strategy.duck.impl.Quack;

/**
 * @author willmao
 * @date 2022-11-12 14:53
 **/
public class MallardDuck extends Duck {
    /**
     * 实例化时，构造器会把继承来的 quackBehavior 实例变量初始化成 Quack 类型的新实例。
     * 同理处理 flyBehavior
     *
     * 但是，我们还是对具体实现编程了，后续使用更多设计模式可以修正这一点。
     */
    public MallardDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck.");
    }
}
