package com.will.asgard.common.mysql.factory;

import com.will.asgard.common.mysql.dao.IUserDAO;
import com.will.asgard.common.mysql.proxy.UserDAOProxy;

public class DAOFactory {
    public static IUserDAO getIUserDAOInstance() {
        return new UserDAOProxy();
    }
}
