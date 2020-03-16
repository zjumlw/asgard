package com.will.asgard.loki.model.interview.alibaba;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.will.asgard.common.util.GsonUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ListRemoveExampleTest {

	@Test
	public void test1() {
		List<Item> list = Lists.newArrayList();
		for (int i = 1; i <= 10; i++) {
			list.add(new Item(i));
		}

		Item item5 = null;
		Item item7 = null;
		for (Item item : list) {
			if (item.getNumber() == 5) {
				item5 = item;
			}
			if (item.getNumber() == 7) {
				item7 = item;
				list.remove(item);
				break;
			}
		}

		list.remove(item5);
		list.remove(item7);
		System.out.println(GsonUtil.toJson(list));
	}

	@Data
	@AllArgsConstructor
	private static class Item {
		private int number;
	}

	@Test
	public void test2() {
		int[] arr = {1,2,3,4,5};

		int[] copied = new int[10];
		System.arraycopy(arr, 1, copied, 2, 4);//5 is the length to copy

		System.out.println(Arrays.toString(copied));
	}

	@Test
	public void test3() {
		int[] arr = {1,2,3,4,5};
		int[] copied = Arrays.copyOf(arr, 10); //10 the the length of the new array
		System.out.println(Arrays.toString(copied));

		copied = Arrays.copyOf(arr, 3);
		System.out.println(Arrays.toString(copied));
	}

	@Test
	public void test4() {
		Object[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int size = arr.length;
		int index = 3;
		int numMoved = size - index - 1;
		System.arraycopy(arr, index + 1, arr, index, numMoved);
		arr[--size] = null; // clear to let GC do its work

		System.out.println(GsonUtil.toJson(arr));
	}
}