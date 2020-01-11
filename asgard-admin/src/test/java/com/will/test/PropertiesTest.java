package com.will.test;

import java.io.InputStream;
import java.util.Properties;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by WillMao on 18-8-14
 */
public class PropertiesTest {
	private static final Logger logger = LoggerFactory.getLogger(PropertiesTest.class);

	@Test
	public void test() {
		logger.error("Error Message!");
		logger.warn("Warn Message!");
		logger.info("Info Message!");
		logger.debug("Debug Message!");
		logger.trace("Trace Message!");
	}

	@Test
	public void getProperties() throws Throwable {
		InputStream in = PropertiesTest.class.getClassLoader().getResourceAsStream(
				"database.properties");
		Properties properties = new Properties();
		properties.load(in);
		String db_driver = properties.getProperty("db.driver");
		String db_url = properties.getProperty("db.url");
		String db_username = properties.getProperty("db.username");
		String db_password = properties.getProperty("db.password");
		String db_myprofile = properties.getProperty("db.myprofile");
		System.out.println("环境:" + db_myprofile);
		System.out.println("驱动:" + db_driver + "\nURL:" + db_url + "\n用户名:" + db_username + "\n密码:"
				+ db_password);

	}
}
