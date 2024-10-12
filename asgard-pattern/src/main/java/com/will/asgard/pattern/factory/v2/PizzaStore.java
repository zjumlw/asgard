package com.will.asgard.pattern.factory.v2;

/**
 * 将创建比萨的方法放回到 PizzaStore 中，但是设置为抽象方法，为每个区域风味创建一个 PizzaStore 的子类。
 *
 * @author willmao
 * @date 2022-11-24 01:43
 **/
public abstract class PizzaStore {

    /**
     * 负责处理订单
     *
     * @param type 类型
     * @return 比萨
     */
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * 把工厂对象移到这个方法中。
     * 从原本的一个对象负责具体类的实例化，变成由一群子类来负责实例化。
     * 这个方法就如同是一个"工厂"。
     *
     * 工厂方法是抽象的，所以依赖子类来处理对象的创建。
     *
     * @param type pizza 类型
     * @return pizza
     */
    abstract Pizza createPizza(String type);
}
