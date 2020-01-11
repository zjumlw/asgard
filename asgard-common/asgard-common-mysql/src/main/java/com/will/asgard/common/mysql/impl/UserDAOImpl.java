package com.will.asgard.common.mysql.impl;

import com.will.asgard.common.model.po.UserPO;
import com.will.asgard.common.mysql.dao.IUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements IUserDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean findLogin(UserPO userPO) throws Exception {
        boolean flag = false;
        try {
            String sql = "SELECT name FROM user WHERE user_id=? AND password=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, userPO.getUserId());
            this.pstmt.setString(2, userPO.getPassword());

            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                userPO.setName(rs.getString(1));
                flag = true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (this.conn != null) {
                try {
                    this.pstmt.close();
                } catch (Exception ex) {
                    throw ex;
                }
            }
        }

        return flag;
    }
}
