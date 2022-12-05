package com.will.asgard.pattern.factory.v1;

import com.will.asgard.pattern.factory.Pizza;

/**
 * @author willmao
 * @date 2022-11-22 23:10
 **/
public class PizzaShopV2 {

    public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        // 通过比萨简单工厂来创建比萨
        Pizza pizza = factory.createPizza("clam");
        System.out.println(pizza.info());
    }
}
