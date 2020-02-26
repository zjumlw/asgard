package com.will.asgard.loki.model.effective.chapter4;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName InstrumentedHashSet
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-25 18:09
 * @Version 1.0
 **/
public class InstrumentedHashSet<E> extends ForwardingSet<E> {
	private int addCount = 0;

	public InstrumentedHashSet(Set<E> s) {
		super(s);
	}


	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		addCount += collection.size();
		return super.addAll(collection);
	}

	public int getAddCount() {
		return addCount;
	}
}
