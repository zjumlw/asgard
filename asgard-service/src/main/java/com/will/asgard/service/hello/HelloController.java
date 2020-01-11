package com.will.asgard.service.hello;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

@Slf4j
public class HelloController {
    public static void main(String[] args) throws Exception {
        System.out.println("hello");
        log.info("hello info");
        Properties p = new Properties();
        DataSource dataSource = BasicDataSourceFactory.createDataSource(p);

    }
}
