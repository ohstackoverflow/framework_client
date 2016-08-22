package com.steven.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.frwk.core.myController;

public class House2Controller  extends myController {

	
	private static Logger logger = Logger.getLogger(House2Controller.class);
	
	public void Index() {
		 Connection conn = null;
		 
		 logger.info("House2...Starting to log for tomcat db pool..");
		 	 
		 
		 
		 String sql;
		 //String url = "jdbc:mysql://" + GetProperty.getPropertyByName("server", "server_ip") +  ":3306/PT?user=root&password=root1";
		 //logger.debug(url);
		 try
		 {
			 //Class.forName("com.mysql.jdbc.Driver");
			 
			 //conn = DriverManager.getConnection(url);
			 conn = DBUtility.getConnection();
			 logger.info("look..look..");
			 Statement stat = conn.createStatement();
			 sql = "select * from pt_user";
			 
			 ResultSet rs = stat.executeQuery(sql);
			 while(rs.next()) {
				 try {
						this.getResponse().getWriter().write( rs.getString("uid") );
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }
			 
			 
			 
		 }catch(Exception ex) {
			 logger.error(ex.getMessage());
			 logger.error(ex.getStackTrace().toString());
			 ex.printStackTrace();
		 }
		 finally {
			 try {
				conn.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				 logger.error(e.getStackTrace().toString());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 
		 
	}

}
