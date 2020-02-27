package com.will.asgard.loki.model.effective.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ClassName GenericErasure
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-27 18:34
 * @Version 1.0
 **/
public class GenericErasure {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>();
		List<?>  ln = li;  // ok
	}

	public void print(Set<String> strSet) { }
//	public void print(Set<Integer> intSet) { } // error
}
