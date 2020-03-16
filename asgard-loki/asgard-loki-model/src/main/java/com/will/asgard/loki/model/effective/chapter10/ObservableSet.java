package com.will.asgard.loki.model.effective.chapter10;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.will.asgard.loki.model.effective.chapter4.ForwardingSet;

/**
 * @ClassName ObservableSet
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-17 00:51
 * @Version 1.0
 **/
public class ObservableSet<E> extends ForwardingSet<E> {
	public ObservableSet(Set<E> s) {
		super(s);
	}

	private final List<SetObserver<E>> observers =
			Lists.newArrayList();

	public void addObserver(SetObserver<E> setObserver) {
		synchronized (observers) {
			observers.add(setObserver);
		}
	}

	public boolean removeObserver(SetObserver<E> setObserver) {
		synchronized (observers) {
			return observers.remove(setObserver);
		}
	}

	private void notifyElementAdded(E element) {
		synchronized (observers) {
			for (SetObserver<E> observer : observers) {
				observer.added(this, element);
			}
		}
	}

	@Override
	public boolean add(E e) {
		boolean added = super.add(e);
		if (added) {
			notifyElementAdded(e);
		}
		return added;
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		boolean result = false;
		for (E e : collection) {
			result |= add(e); // calls notifyElementAdded
		}
		return result;
	}
}
