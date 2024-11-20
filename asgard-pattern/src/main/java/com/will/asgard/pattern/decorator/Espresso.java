package com.will.asgard.pattern.decorator;

/**
 * 浓缩咖啡。
 *
 * @author willmao
 * @date 2022-11-17 00:25
 **/
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    /**
     * 不用关心调料的价格，直接把 Espresso 的价格返回即可。
     *
     * @return Espresso 的价格
     */
    @Override
    public double cost() {
        return 1.99;
    }
}
