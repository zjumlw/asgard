package com.will.asgard.loki.model.builderpattern;

/**
 * Created by WillMao on 19-5-8
 *
 * <p>该类是一个抽象类,其中我们声明了4个抽象方法,前面三个是负责给产品添加不同的部件,第四个方法是负责建造产品。
 * 但这只是一个框架,还没有具体的实现。
 */
public abstract class Builder {

	public abstract void setPart1();

	public abstract void setPart2();

	public abstract void setPart3();

	public abstract Product builderProduct();
}
