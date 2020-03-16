package com.will.asgard.loki.model.effective.chapter10;

import java.util.HashSet;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObservableSetTest {

	@Test
	public void test1() {
		ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

		set.addObserver(new SetObserver<Integer>() {
			@Override
			public void added(ObservableSet<Integer> set, Integer element) {
				System.out.println(element + " is added");
			}
		});

		for (int i = 0; i < 10; i++) {
			set.add(i);
		}
	}
}