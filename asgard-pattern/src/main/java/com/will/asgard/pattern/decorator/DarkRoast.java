package com.will.asgard.pattern.decorator;

/**
 * 深焙咖啡。
 *
 * @author willmao
 * @date 2022-11-17 00:29
 **/
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast";
    }

    @Override
    public double cost() {
        return 1.2;
    }
}
