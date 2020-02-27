package com.will.asgard.loki.model.effective.chapter5.genericerasure;

/**
 * @ClassName ErasedNode
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-27 18:36
 * @Version 1.0
 **/
public class ErasedNode {
	//由于K是没有限制的，将其替换成Object
	private Object data;
	//而V上限为Number，将其替换成Number
	private Number next;
	//方法中的也会进行替换
	public ErasedNode(Object data, Number next) {
		this.data = data;
		this.next = next;
	}

	public Object getData() {
		return data;
	}
}
