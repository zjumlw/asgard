package com.will.asgard.frigg.mysql.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-13 上午12:26
 * @Version 1.0
 */
public class MyBatisUtils {

    private static final String resource = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            InputStream  inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession(true);
    }
}
