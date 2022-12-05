package com.will.asgard.pattern.decorator;

/**
 * 饮料抽象类，所有子类需要实现 cost 方法。
 * 违反了 2 个设计原则：
 *  1. 针对接口编程而不是针对实现编程
 *  2. 多用组合，少用继承
 *
 * @author willmao
 * @date 2022-11-16 18:52
 **/
public abstract class Beverage {

    /**
     * 描述饮料
     */
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    /**
     * 子类必须要实现 cost 方法，然后计算每种调料的价格，最后得到总的价格。
     */
    public abstract double cost();
}
