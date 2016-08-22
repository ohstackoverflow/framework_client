package com.steven.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;


public class DBUtility {

	private static Logger logger = Logger.getLogger(DBUtility.class);
	
	{
		logger.info("DBUtility starting...");
	}
	
	static DataSource dataSource = new DataSource();

	
	
	static {
		logger.info("Starting db pool initializing..");
		PoolProperties poolProperties = new PoolProperties();
		Properties dbProperties = new Properties();
		try {
			dbProperties.load(DBUtility.class.getClassLoader().getResourceAsStream("server.properties"));
		} catch (Exception e) {
			logger.error(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		poolProperties.setUrl(dbProperties.getProperty("url"));
		poolProperties.setDriverClassName(dbProperties.getProperty("driver"));
		poolProperties.setUsername(dbProperties.getProperty("username"));
		poolProperties.setPassword(dbProperties.getProperty("password"));
		
		poolProperties.setInitialSize(Integer.valueOf(dbProperties.getProperty("initialSize")));
		dataSource.setPoolProperties(poolProperties);		
	}
	
	
	public static final Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
