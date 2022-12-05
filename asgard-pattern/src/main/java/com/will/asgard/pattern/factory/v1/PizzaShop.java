package com.will.asgard.pattern.factory.v1;

import com.will.asgard.pattern.factory.Pizza;

/**
 * @author willmao
 * @date 2022-11-22 22:59
 **/
public class PizzaShop {

    public static void main(String[] args) {
        String type = "cheese";
        Pizza pizza = orderPizza(type);
        System.out.println(pizza.info());
    }

    private static Pizza orderPizza(String type) {
        Pizza pizza;
        // 这里的代码没有对修改封闭，如果改变比萨风味就需要改动
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else {
            pizza = new SimplePizza();
        }

        // 希望不改动的地方
        pizza.prepare();
        pizza.bake();
        pizza.cut();;
        pizza.box();
        return pizza;
    }
}
