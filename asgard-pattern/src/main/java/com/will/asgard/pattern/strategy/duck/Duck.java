package com.will.asgard.pattern.strategy.duck;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 鸭子将飞行和呱呱叫的动作委托别人处理，而不是使用定义在类内的呱呱叫和飞行方法。
 *
 * @author willmao
 * @date 2022-11-12 14:12
 **/
@Data
@NoArgsConstructor
public abstract class Duck {
    /**
     * 行为变量被声明为行为"接口"类型，不再需要 fly() 方法，而使用相似的 {@link this#performFly} 方法
     */
    private FlyBehavior flyBehavior;

    private QuackBehavior quackBehavior;

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public abstract void display();
}
