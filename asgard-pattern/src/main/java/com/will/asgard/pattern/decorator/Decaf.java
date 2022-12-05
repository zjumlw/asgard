package com.will.asgard.pattern.decorator;

/**
 * 脱因咖啡。
 *
 * @author willmao
 * @date 2022-11-17 00:30
 **/
public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 0.5;
    }
}
