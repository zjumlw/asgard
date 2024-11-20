package com.will.asgard.pattern.decorator;

/**
 * 摩卡装饰者。
 *
 * @author willmao
 * @date 2022-11-17 00:31
 **/
public class Mocha extends CondimentDecorator {

    /**
     * 被装饰者，可以是任何一个饮料
     */
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * 利用委托的方式，得到价格，然后加上摩卡的价格。
     *
     * @return 价格
     */
    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }

    /**
     * 利用委托的方式，得到一个描述，然后加上附加的描述。
     *
     * @return 饮料的描述
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
