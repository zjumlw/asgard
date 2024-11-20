package com.will.asgard.pattern.decorator;

/**
 * 豆浆。
 *
 * @author willmao
 * @date 2022-11-17 00:35
 **/
public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.3;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
