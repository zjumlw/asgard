package com.will.asgard.loki.model.effective;

import java.util.Arrays;
import java.util.EmptyStackException;

import com.will.asgard.common.util.GsonUtil;

/**
 * @ClassName Stack
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-14 11:49
 * @Version 1.0
 **/
public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		Object result = elements[--size];
		// Eliminate obsolete reference
		elements[size] = null;
		return result;
	}

	public void status() {
		System.out.println("elements:" + GsonUtil.toJson(elements));
		System.out.println("elements length: " + elements.length);
		System.out.println("size: " + size);
		System.out.println("--------");
	}

	public Object[] getElements() {
		return elements;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

}
