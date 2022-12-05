package com.will.asgard.pattern.decorator;

/**
 * @author willmao
 * @date 2022-11-17 00:37
 **/
public class StarbuzzCoffee {

    public static void main(String[] args) {
        // 纯浓缩，不要添加调料
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        // 用两个 Mocha 来装饰
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        // 用一个 Whip 来装饰
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
