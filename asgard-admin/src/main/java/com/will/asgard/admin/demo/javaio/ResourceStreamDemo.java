package com.will.asgard.admin.demo.javaio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceStreamDemo {

	public static void main(String[] args) throws Throwable {
		InputStream in = ResourceStreamDemo.class.getClassLoader().getResourceAsStream("books/test.txt");
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader bf = new BufferedReader(reader);
		String line = "";
		while ((line = bf.readLine()) != null) {
			System.out.println(line);
		}
	}

}
