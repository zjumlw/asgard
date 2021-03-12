package com.will.asgard.loki.model.generic.wildcards;

import com.will.asgard.common.util.GsonUtil;

/**
 * Created by WillMao on 19-1-18
 */
public class Main {

    public static void main(String[] args) {
        Plate<Apple> applePlate = new Plate<>(new Apple(1.0));
        Plate<Fruit> fruitPlate = new Plate<>(new Fruit());
        Plate<Food> foodPlate = new Plate<>(new Food());

        System.out.println("----extends----");
        // 可以放水果以及水果派生类的盘子，是applePlate和fruitPlate的基类
        Plate<? extends Fruit> plate = applePlate;
        // 初始化/赋值完成之后，只能从里面拿，不能放进去；且拿出来的元素认为是Fruit或者其基类
        Fruit fruit = plate.getItem();
        System.out.println("plate from applePlate: " + GsonUtil.toJson(plate));
        System.out.println("fruit: " +GsonUtil.toJson(fruit));

        plate = fruitPlate;
        // 只能拿，不能放
        fruit = plate.getItem();
        System.out.println("plate from fruitPlate: " + GsonUtil.toJson(plate));
        System.out.println("fruit: " + GsonUtil.toJson(fruit));

        System.out.println("----super----");
        // 可以放水果以及水果基类的盘子，可以是fruitPlate或者foodPlate
        Plate<? super Fruit> plate1 = foodPlate;
        // 可以放，但是不知道拿出来是啥(只能是Object),所以认为不可拿
        plate1.setItem(new Fruit(1.5));
        Object res = plate1.getItem();
        System.out.println("plate from foodPlate: " + GsonUtil.toJson(plate1));
        System.out.println("obj: " + GsonUtil.toJson(res));

        plate1 = fruitPlate;
        // 可以放，但是不知道拿出来是啥，所以认为不可拿
        plate1.setItem(new Apple(1.2));
        res = plate1.getItem();
        System.out.println("plate from fruitPlate: " + GsonUtil.toJson(plate1));
        System.out.println("obj: " + GsonUtil.toJson(res));

        Plate<? super Apple> plate2 = foodPlate;
    }
}
