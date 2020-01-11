package com.will.asgard.common.biz.service.account;

import com.will.asgard.common.employee.Account;
import com.will.asgard.common.mysql.dao.AccountDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WillMao on 18-9-11
 */
@Service
public class AccountBiz {
	private static final Logger logger = LoggerFactory.getLogger(AccountBiz.class);

	@Autowired
	private AccountDAO accountDAO;

	public Account getAccountById(int id) {
		return accountDAO.getAccountById(id);
	}

	public void insertIfNotExist(Account account) {
		Account acct = accountDAO.getAccountById(account.getId());
		if (acct == null) {
			logger.debug("No {} found, would insert it.",account);
			accountDAO.saveAccount(account);
		}
		acct=null;
	}

}
