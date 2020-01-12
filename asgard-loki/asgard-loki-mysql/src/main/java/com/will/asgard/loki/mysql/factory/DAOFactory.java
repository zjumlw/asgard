package com.will.asgard.loki.mysql.factory;

import com.will.asgard.loki.mysql.dao.IUserDAO;
import com.will.asgard.loki.mysql.proxy.UserDAOProxy;

public class DAOFactory {
    public static IUserDAO getIUserDAOInstance() {
        return new UserDAOProxy();
    }
}
