package com.will.asgard.loki.model.generic.wildcards;

import java.util.List;

import com.google.common.collect.Lists;
import com.will.asgard.common.util.GsonUtil;

/**
 * @ClassName FruitMain
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-26 15:03
 * @Version 1.0
 **/
public class FruitMain {

    public static void main(String[] args) {
        List<Fruit> fruits = Lists.newArrayList();
        // 可以在 list 中 add Fruit 以其子类
        fruits.add(new Fruit(1));
        fruits.add(new Apple(1.2));
        fruits.add(new Banana(2));
        System.out.println(GsonUtil.toJson(fruits));

        // 可以将 fruits 赋值给上界通配符的 List
        List<? extends Fruit> plate = fruits;
        Fruit res = plate.get(0);
        System.out.println(GsonUtil.toJson(res));
    }
}
