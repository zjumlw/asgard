package com.will.asgard.common.mysql.dao;

import com.will.asgard.common.model.po.UserPO;

public interface IUserDAO {
    boolean findLogin(UserPO userPO) throws Exception;
}
