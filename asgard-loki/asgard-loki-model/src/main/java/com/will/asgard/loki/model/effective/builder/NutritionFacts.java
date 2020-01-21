package com.will.asgard.loki.model.effective.builder;



/**
 * @ClassName NutritioniFacts
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-01-21 11:50
 * @Version 1.0
 **/
public class NutritionFacts {
	private final int serviceSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	public static class Builder {
		private final int serviceSize;
		private final int servings;
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;

		public Builder(int serviceSize, int servings) {
			this.serviceSize = serviceSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			this.calories = val;
			return this;
		}

		public Builder fat(int val) {
			this.fat = val;
			return this;
		}

		public Builder sodium(int val) {
			this.sodium = val;
			return this;
		}

		public Builder carnohydrate(int val) {
			this.carbohydrate = val;
			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}

	private NutritionFacts(Builder builder) {
		serviceSize = builder.serviceSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}

	public static void main(String[] args) {
		NutritionFacts nutritionFacts = new NutritionFacts.Builder(100, 50).build();
		System.out.println(nutritionFacts.fat);
	}
}
