package com.will.asgard.loki.model.effective.chapter5;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

import com.will.asgard.common.util.GsonUtil;

/**
 * @ClassName Stack
 * @Description Generic stack
 * @Author maolingwei
 * @Date 2020-02-27 22:47
 * @Version 1.0
 **/
public class Stack<E> {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public void pushAll(Iterable<? extends E> src) {
		for (E e : src) {
			push(e);
		}
	}

	public E pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		@SuppressWarnings("unchecked")
		E result = (E) elements[--size];
		elements[size] = null;
		return result;
	}

	public void popAll(Collection<? super E> dst) {
		while (!isEmpty()) {
			dst.add(pop());
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

	public Object[] getElements() {
		return elements;
	}

	public void status() {
		System.out.println("elements:" + GsonUtil.toJson(elements));
		System.out.println("elements length: " + elements.length);
		System.out.println("size: " + size);
		System.out.println("--------");
	}
}
