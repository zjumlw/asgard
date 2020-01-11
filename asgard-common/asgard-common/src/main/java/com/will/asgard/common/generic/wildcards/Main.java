package com.will.asgard.common.generic.wildcards;

/**
 * Created by WillMao on 19-1-18
 */
public class Main {

	public static void main(String[] args) {
		Plate<Apple> applePlate = new Plate<Apple>(new Apple());
		Plate<Fruit> fruitPlate = new Plate<Fruit>(new Fruit());
		// Plate<Food> foodPlate = new Plate<>(new Food());
		// 可以放水果以及水果派生类的盘子，是applePlate和fruitPlate的基类
		Plate<? extends Fruit> plate = applePlate;
		Fruit fruit = plate.getItem();

		// 可以放水果以及水果基类的盘子，可以是fruitPlate或者foodPlate
		// Plate<? super Fruit> plate1 = foodPlate;

	}
}
