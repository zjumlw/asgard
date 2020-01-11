package com.will.asgard.common.mysql.proxy;

import com.will.asgard.common.core.model.po.UserPO;
import com.will.asgard.common.mysql.DatabaseConnection;
import com.will.asgard.common.mysql.dao.IUserDAO;
import com.will.asgard.common.mysql.impl.UserDAOImpl;

public class UserDAOProxy implements IUserDAO {
    private DatabaseConnection dbc = null;
    private IUserDAO dao = null;

    public UserDAOProxy() {
        try {
            this.dbc = new DatabaseConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.dao = new UserDAOImpl(this.dbc.getConnection());
    }

    @Override
    public boolean findLogin(UserPO userPO) throws Exception {
        boolean flag = false;
        try {
            flag = this.dao.findLogin(userPO);
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.dbc.close();
        }

        return flag;
    }
}
