package com.will.asgard.loki.mysql;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DatabaseConnection {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/will";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123";
    private static final String DS_NAME = "java:comp/env/jdbc/asgard";

    private Connection connection = null;
    public DatabaseConnection() throws Exception {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup(DS_NAME);
            this.connection = ds.getConnection();
//            Class.forName(DB_DRIVER);
//            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void close() throws Exception {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (Exception ex) {
                throw ex;
            }
        }
    }


}
