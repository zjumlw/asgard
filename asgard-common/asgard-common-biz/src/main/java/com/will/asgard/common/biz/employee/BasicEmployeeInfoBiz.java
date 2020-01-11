package com.will.asgard.common.biz.employee;

import com.will.asgard.common.core.employee.Account;

/**
 * Created by WillMao on 18-9-11
 */
public class BasicEmployeeInfoBiz {
	public static void main(String[] args) {
		Account account = Account.getAccount(1,"will",18,Account.SEX_MALE);
		System.out.println(account.toString());
	}
}
