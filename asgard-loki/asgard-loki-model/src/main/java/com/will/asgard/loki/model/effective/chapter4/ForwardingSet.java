package com.will.asgard.loki.model.effective.chapter4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName ForwardingSet
 * @Description Reusable forwarding class
 * @Author maolingwei
 * @Date 2020-02-25 21:46
 * @Version 1.0
 **/
public class ForwardingSet<E> implements Set<E> {
	private final Set<E> s;

	public ForwardingSet(Set<E> s) {
		this.s = s;
	}

	@Override
	public int size() {
		return s.size();
	}

	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return s.contains(0);
	}

	@Override
	public Iterator<E> iterator() {
		return s.iterator();
	}

	@Override
	public Object[] toArray() {
		return s.toArray();
	}

	@Override
	public <T> T[] toArray(T[] ts) {
		return s.toArray(ts);
	}

	@Override
	public boolean add(E e) {
		System.out.println("add: " + e);
		return s.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return s.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return s.containsAll(collection);
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		System.out.println("add all: " + collection);
		return s.addAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return s.retainAll(collection);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return s.retainAll(collection);
	}

	@Override
	public void clear() {
		s.clear();
	}
}
