package com.will.asgard.loki.model.algs4.chapter1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName Stack
 * @Description use node
 * @Auther maolingwei
 * @Date 2020-04-26 20:20
 * @Version 1.0
 **/
public class LinkedStack<E> implements Iterable<E> {
	private Node first;
	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void push(E e) {
		Node newOne = new Node(e);
		newOne.next = first;
		first = newOne;
		size++;
	}

	public E pop() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		E item = first.item;
		first = first.next;
		size--;
		return item;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	private class Node {
		E item;
		Node next;

		public Node(E e) {
			this.item = e;
		}
	}
}
