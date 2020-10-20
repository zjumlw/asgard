package com.will.asgard.loki.model.generic.wildcards.zoo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-10-20 16:18
 * @Version 1.0
 **/
class LegMain {

    static int countLegs(List<? extends Animal> animals) {
        int ans = 0;
        if (CollectionUtils.isNotEmpty(animals)) {
            for (Animal animal : animals) {
                ans += animal.getLags();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // 1. 将 List<Dog> 赋值给 List<? extends Animal>
        List<Dog> dogs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dogs.add(new Dog());
        }
        int dogLegs = countLegs(dogs);
        System.out.println("dog legs: " + dogLegs);

        // 2. 将 List<Chicken> 赋值给 List<? extends Animal>
        List<Chicken> chickens = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            chickens.add(new Chicken());
        }
        int chickenLegs = countLegs(chickens);
        System.out.println("chicken legs: " + chickenLegs);

        // 3. 将 dog 和 chicken 都塞到 List<Animal> 中，然后将 List<Animal> 赋值给 List<? extends Animal>
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            animals.add(new Dog());
            animals.add(new Chicken());
        }
        int totalLegs = countLegs(animals);
        System.out.println("total legs: " + totalLegs);

        // 4. 无法将 List<? super Animal> 赋值给 List<? extends Animal>
        List<? super Animal> animals1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            animals.add(new Dog());
            animals.add(new Chicken());
        }
//        int totalLegs1 = countLegs(animals1);
//        System.out.println("total legs1: " + totalLegs1);
    }
}
