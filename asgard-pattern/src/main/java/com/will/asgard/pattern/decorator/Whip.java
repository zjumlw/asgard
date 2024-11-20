package com.will.asgard.pattern.decorator;

/**
 * 奶泡。
 *
 * @author willmao
 * @date 2022-11-17 00:35
 **/
public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.4 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}
