package com.will.asgard.pattern.decorator;

/**
 * 首选咖啡。
 *
 * @author willmao
 * @date 2022-11-17 00:27
 **/
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
