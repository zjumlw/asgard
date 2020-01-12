package com.will.asgard.loki.mysql.proxy;

import com.will.asgard.loki.mysql.DatabaseConnection;
import com.will.asgard.loki.mysql.dao.IUserDAO;
import com.will.asgard.loki.mysql.impl.UserDAOImpl;
import com.will.asgard.loki.model.entity.po.UserPO;

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
