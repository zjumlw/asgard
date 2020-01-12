package com.will.asgard.loki.mysql.dao;


import com.will.asgard.loki.model.entity.po.UserPO;

public interface IUserDAO {
    boolean findLogin(UserPO userPO) throws Exception;
}
