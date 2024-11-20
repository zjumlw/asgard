package com.will.asgard.pattern.strategy.duck.impl;

import com.will.asgard.pattern.strategy.duck.Animal;

/**
 * @author willmao
 * @date 2022-11-12 14:36
 **/
public class Cat implements Animal {

    @Override
    public void makeSound() {
        meow();
    }

    private void meow() {
        System.out.println("cat meow");
    }
}
