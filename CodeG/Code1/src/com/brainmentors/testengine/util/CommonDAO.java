package com.brainmentors.testengine.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public interface CommonDAO {
	Logger logger = Logger.getLogger(CommonDAO.class);
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String dbUrl = rb.getString("url");
		String userid = rb.getString("userid");
		String password = rb.getString("password");
		Connection con =DriverManager.getConnection(dbUrl,userid,password);
//		Connection con = DriverManager.
//				getConnection("jdbc:postgresql://localhost:5432/exam"
//						,"amit","amit123");
		return con;
	}

}





