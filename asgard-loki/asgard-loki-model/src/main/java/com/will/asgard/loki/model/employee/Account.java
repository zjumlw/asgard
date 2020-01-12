package com.will.asgard.loki.model.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by WillMao on 18-9-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	public static final String SEX_MALE = "male";
	public static final String SEX_FEMALE = "female";

	private int id;
	private String name;
	private int age;
	private String sex;
}
