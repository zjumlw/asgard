package com.will.asgard.loki.model.proxy.dongtai.user.impl;

import com.will.asgard.loki.model.proxy.dongtai.user.UserDao;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-01-11 下午7:39
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("saving user info");
    }
}
