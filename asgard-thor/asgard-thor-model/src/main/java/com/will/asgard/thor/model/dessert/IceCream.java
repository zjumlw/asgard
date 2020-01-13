package com.will.asgard.thor.model.dessert;

import org.springframework.stereotype.Component;

@Component
public class IceCream implements Dessert {
    @Override
    public void eat() {
        System.out.println("Eat ice cream");
    }
}
