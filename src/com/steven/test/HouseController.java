package com.steven.test;

import org.apache.log4j.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import com.frwk.core.myController;

public class HouseController extends myController {

	
	private static Logger logger = Logger.getLogger(HouseController.class);
	
	public void Index() {
		 Connection conn = null;
		 
		 String sql;
		 String url = "jdbc:mysql://" + GetProperty.getPropertyByName("server", "server_ip") +  ":3306/PT?user=root&password=root1";
		 logger.debug(url);
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 conn = DriverManager.getConnection(url);
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
	
	
	public void Update() {
		
		System.out.println("request: " + this.getRequest() );
		System.out.println("response: " + this.getResponse() );
		System.out.println("userID: " + this.getRequest().getParameter("userID"));
		System.out.println("什么re..");
		
		String str = "";
		try {
			str = new String( this.getRequest().getParameter("userID").getBytes("ISO-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			this.getResponse().getWriter().write("userID: " + str );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Add() {
		System.out.println("test only");
		try {
			this.getResponse().getWriter().write("111111111  writing some response..知道了吗..");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.getRequest().getRequestDispatcher("/WEB-INF/views/house/add.html").forward(this.getRequest(), this.getResponse());
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
