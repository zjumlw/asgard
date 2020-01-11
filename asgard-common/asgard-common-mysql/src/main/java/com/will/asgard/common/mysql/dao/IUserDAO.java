package com.will.asgard.common.mysql.dao;

import com.will.asgard.common.core.model.po.UserPO;

public interface IUserDAO {
    boolean findLogin(UserPO userPO) throws Exception;
}
