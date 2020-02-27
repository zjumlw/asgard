package com.will.asgard.loki.model.effective.chapter5.genericerasure;

/**
 * @ClassName Node
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-27 18:35
 * @Version 1.0
 **/
public class Node<K, V extends Number> {
	private K data;
	private V next;

	public Node(K data, V next) {
		this.data = data;
		this.next = next;
	}

	public K getData() { return data; }
}
