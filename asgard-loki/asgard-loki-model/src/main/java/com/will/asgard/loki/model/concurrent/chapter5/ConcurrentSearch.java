package com.will.asgard.loki.model.concurrent.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ConcurrentSearch
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-13 17:19
 * @Version 1.0
 **/
public class ConcurrentSearch {
	private static int[] arr;
	private static ExecutorService pool = Executors.newCachedThreadPool();
	private static final int THREAD_NUM = 2;
	private static AtomicInteger result = new AtomicInteger(-1);

	public static int search(int searchValue, int beginPos, int endPos) {
		System.out.println("searchValue=" + searchValue + ",begin=" + beginPos + ",end=" + endPos);
		int i = 0;
		for (i = beginPos; i < endPos; i++) {
			if (result.get() >= 0) {
				return result.get();
			}
			if (arr[i] == searchValue) {
				if (!result.compareAndSet(-1, i)) {
					return result.get();
				}
				return i;
			}
		}
		return -1;
	}

	private static class SearchTask implements Callable<Integer> {
		private int begin;
		private int end;
		private int searchValue;

		public SearchTask(int begin, int end, int searchValue) {
			this.begin = begin;
			this.end = end;
			this.searchValue = searchValue;
		}

		@Override
		public Integer call() throws Exception {
			return search(searchValue, begin, end);
		}
	}

	private static int pSearch(int searchValue) throws ExecutionException, InterruptedException {
		int subArrSize = arr.length / THREAD_NUM + 1;
		List<Future<Integer>> re = new ArrayList<>();
		for (int i = 0; i < arr.length; i += subArrSize) {
			int end = i + subArrSize;
			if (end > arr.length) {
				end = arr.length;
			}

			re.add(pool.submit(new SearchTask(i, end, searchValue)));
		}
		for (Future<Integer> future : re) {
			if (future.get() >= 0) {
				return future.get();
			}
		}

		return -1;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		arr = new int[10000];
		for (int i = 0; i < 10000; i++) {
			arr[i] = i * i;
		}

		System.out.println(pSearch(4000000));
	}
}
