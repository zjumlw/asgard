package com.will.asgard.common.mysql.dao;

import com.will.asgard.common.core.employee.Account;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WillMao on 18-9-11
 */
@Service
public class AccountDAO extends NamedParameterJdbcDaoSupport {
	public void saveAccount(Account account) {
		String sql = "insert into tbl_account(id,name,age,sex) " +
				"values(:id,:name,:age,:sex)";
		Map paramMap = new HashMap();
		paramMap.put("id", account.getId());
		paramMap.put("name", account.getName());
		paramMap.put("age", account.getAge());
		paramMap.put("sex",account.getSex());
		getNamedParameterJdbcTemplate().update(sql, paramMap);
	}

	public Account getAccountById(int id) {
		String sql = "select id,name,age,sex from tbl_account where id=:id";
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		List<Account> matches = getNamedParameterJdbcTemplate().query(sql,
				paramMap,new RowMapper<Account>() {

					@Override
                    public Account mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Account a = new Account();
						a.setId(rs.getInt(1));
						a.setName(rs.getString(2));
						a.setAge(rs.getInt(3));
						a.setSex(rs.getString(4));
						return a;
					}

				});
		return matches.size()>0?matches.get(0):null;
	}

    public static void main(String[] args) {
        System.out.println("aa");
    }
}
