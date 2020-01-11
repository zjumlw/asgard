package com.will.asgard.common.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.google.gson.Gson;

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

	public static Account getAccount(int id, String name, int age, String sex) {
		Account acct = new Account();
		acct.setId(id);
		acct.setName(name);
		acct.setAge(age);
		acct.setSex(sex);
		return acct;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
