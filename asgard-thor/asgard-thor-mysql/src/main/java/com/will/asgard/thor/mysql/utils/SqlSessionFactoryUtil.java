package com.will.asgard.thor.mysql.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-12 6:05 下午
 * @Version 1.0
 */
@Slf4j
public class SqlSessionFactoryUtil {

    public static SqlSessionFactory getFactory() {
        SqlSessionFactory sessionFactory = null;
        try (InputStream is = SqlSessionFactoryUtil.class.getClassLoader().getResourceAsStream("mybatis-config.xml")) {
            sessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public static SqlSession openSession(boolean isAutoCommit) {
        return getFactory().openSession(isAutoCommit);
    }

    public static void closeSession(SqlSession session) {
        if (session != null) {
            session.close();
        }
    }
}
