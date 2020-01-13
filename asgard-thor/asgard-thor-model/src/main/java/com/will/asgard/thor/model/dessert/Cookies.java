package com.will.asgard.thor.model.dessert;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cookies implements Dessert {
    @Override
    public void eat() {
        System.out.println("Eat cookies");
    }
}
