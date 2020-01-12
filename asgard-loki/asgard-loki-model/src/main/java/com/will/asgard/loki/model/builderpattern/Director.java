package com.will.asgard.loki.model.builderpattern;

/**
 * Created by WillMao on 19-5-8
 *
 * <p>指导具体构建者类如何制造产品啦。制造完的产品会交给导演类负责处理。
 */
public class Director {

	private Builder builder = new ConcreteBuilder();

	public Product build() {
		builder.setPart1();
		builder.setPart2();
		builder.setPart3();

		return builder.builderProduct();
	}

}
