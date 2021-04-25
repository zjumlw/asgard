package com.will.asgard.algo.algs4.chapter1;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.annotation.Nonnull;

/**
 * @ClassName ResizingArrayStack
 * @Description rt
 * @Auther maolingwei
 * @Date 2020-04-26 19:56
 * @Version 1.0
 **/
public class ResizingArrayStack<E> implements Iterable<E> {
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	private Object[] a;
	private int size = 0;

	public ResizingArrayStack() {
		a = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	private void resize(int newCapacity) {
		Object[] temp =  new Object[newCapacity];
		if (size >= 0) {
			System.arraycopy(a, 0, temp, 0, size);
		}
		a = temp;
	}

	public void push(E item) {
		if (size == a.length) {
			resize(2 * a.length);
		}
		a[size++] = item;
	}

	public E pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		E item = (E) a[--size];
		a[size] = null;
		if (size > 0 && size == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}

	@Override
	@Nonnull
	public Iterator<E> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<E> {
		private int i = size;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return (E) a[--i];
		}
	}
}
