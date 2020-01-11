package com.will.lambda;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by WillMao on 19-2-27
 */
@Slf4j
public class LambdaTest {

	@Test
	public void test() {
		Comparator<String> c = (s1, s2) -> s1.compareToIgnoreCase(s2);
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		};

		new Thread(toDoLater()).start();
		new Thread(toDoLater()).start();
		new Thread(toDoLater()).start();

	}

	public Runnable toDoLater() {
		return () -> {
			System.out.println(Thread.currentThread().getName() + " later");
		};
	}

	@Test
	public void testRef() {
		Comparator<Person> byName1 = Comparator.comparing(new Function<Person, String>() {
			@Override
			public String apply(Person person) {
				return person.getName();
			}
		});

		Comparator<Person> byName2 = Comparator.comparing(person -> person.getName());

		Comparator<Person> byName3 = Comparator.comparing(Person::getName);

		Consumer<String> consumer = System.out::println;
		consumer.accept("This is Major Tom");
	}

}
