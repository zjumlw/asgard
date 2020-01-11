package com.will.asgard.admin.demo.serializedemo;

import com.google.gson.Gson;
import com.will.asgard.admin.demo.model.Person;

/**
 * Created by WillMao on 18-8-30
 */
public class TransientDemo {
	public static void main(String[] args) {
		Person person = new Person(10, "wang", "beijing", "wang@163.com", "1234qwer");
		String personJson = new Gson().toJson(person);
		System.out.println(personJson);
	}
}
