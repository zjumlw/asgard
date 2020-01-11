package com.will.asgard.admin.demo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by WillMao on 18-8-30
 */
@Data
@AllArgsConstructor
public class Person implements Serializable {
	private int age;
	private String name;
	private String address;
	private String email;
	// transient对于gson序列化也有效果
	private transient String password;
}
