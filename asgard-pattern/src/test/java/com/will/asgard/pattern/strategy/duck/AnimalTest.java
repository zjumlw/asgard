package com.will.asgard.pattern.strategy.duck;

import com.will.asgard.pattern.strategy.duck.Animal;
import com.will.asgard.pattern.strategy.duck.impl.Cat;
import com.will.asgard.pattern.strategy.duck.impl.Dog;

import org.junit.Test;

/**
 * @author willmao
 * @date 2022-11-12 14:37
 **/
public class AnimalTest {

    @Test
    public void testMakeSound() {
        Animal dog = new Dog();
        dog.makeSound();

        Animal cat = new Cat();
        cat.makeSound();
    }
}