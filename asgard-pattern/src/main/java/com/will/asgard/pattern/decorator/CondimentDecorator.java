package com.will.asgard.pattern.decorator;

/**
 * 调料装饰者抽象类，所有调料子类需要继承此类。
 *
 * @author willmao
 * @date 2022-11-17 00:22
 **/
public abstract class CondimentDecorator extends Beverage {

    /**
     * 获取饮料的描述。
     * 所有调料装饰者必须重新实现 getDescription 方法。
     *
     * @return 描述
     */
    public abstract String getDescription();
}
