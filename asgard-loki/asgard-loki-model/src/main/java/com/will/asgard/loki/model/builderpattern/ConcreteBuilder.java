package com.will.asgard.loki.model.builderpattern;

/**
 * Created by WillMao on 19-5-8
 *
 * <p>该类会继承自抽象建造者类Builder,并实现其中的方法。开始先声明一个产品,
 * 然后在各个setPart方法中添加具体的逻辑,然后在builderProduct()方法中返回生产好的产品。
 */
public class ConcreteBuilder extends Builder {

	private Product product = new Product();


	@Override
	public void setPart1() {

	}

	@Override
	public void setPart2() {

	}

	@Override
	public void setPart3() {

	}

	@Override
	public Product builderProduct() {
		return product;
	}
}
