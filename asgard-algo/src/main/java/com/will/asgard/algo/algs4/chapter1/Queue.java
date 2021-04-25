package com.will.asgard.algo.algs4.chapter1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName Queue
 * @Description rt
 * @Auther maolingwei
 * @Date 2020-04-26 20:37
 * @Version 1.0
 **/
public class Queue<E> implements Iterable<E> {
	private Node first;
	private Node last;
	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void enqueue(E item) {
		Node oldlast = last;
		last = new Node(item);
		last.next = null;

		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}

		size++;
	}

	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E item = first.item;
		first = first.next;
		size--;
		if (isEmpty()) {
			last = null;
		}

		return item;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	private class Node {
		E item;
		Node next;

		public Node(E item) {
			this.item = item;
		}
	}
}
