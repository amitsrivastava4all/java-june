package com.brainmentors.testengine.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brainmentors.testengine.user.dto.UserDTO;
import com.brainmentors.testengine.util.CommonDAO;
import com.brainmentors.testengine.util.constants.QueryConstants;

class A{
	static{
		System.out.println("A Class Loaded...");
	}
}

public class UserDAO {
	Logger logger = Logger.getLogger(UserDAO.class);
	
	public String doRegister(UserDTO userDTO) throws SQLException, ClassNotFoundException{
		Connection connection = null;
		PreparedStatement pstmt = null;
		try{
			connection = CommonDAO.getConnection();
			pstmt = connection.prepareStatement(QueryConstants.REGISTER_SQL);
			pstmt.setString(1, userDTO.getUserid());
			pstmt.setString(2, userDTO.getPassword());
			int insertedCount = pstmt.executeUpdate();
			return insertedCount>0?"Register SuccessFully":"Can't Register";
		
		}
		finally{
			logger.debug("INside Finally ");
			
			
			if(pstmt!=null){
			pstmt.close();
			}
			if(connection!=null){
			connection.close();
			}
		}
	}
	
	public String doLogin(String userid, String password) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		logger.debug("Inside UserDAO doLogin  Going to Make COnnection...");	
		connection = CommonDAO.getConnection();
		
		
		 pstmt = connection.prepareStatement(QueryConstants.LOGIN_SQL);
		pstmt.setString(1, userid);
		pstmt.setString(2, password);
		
		 rs = pstmt.executeQuery();
		 logger.debug("Query Execute....");
		while(rs.next()){
		}	
//		 //if(rs.next()){
//			return "Welcome "+userid;
//		}
//		else{
//			return "Invalid Userid or Password";
//		}
		return null;
	}
	finally{
		logger.debug("INside Finally ");
		// Step -5 Close the Resources
		if(rs!=null){
		rs.close();
		}
		if(pstmt!=null){
		pstmt.close();
		}
		if(connection!=null){
		connection.close();
		}
	}
		
	}
	
/*public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//A obj = new A();
	//Class.forName("com.brainmentors.testengine.user.dao.A1");
	// Step - 1 Load a Driver , Driver is a Class 
	// Load a Class
	Scanner s = new Scanner(System.in);
	System.out.println("Enter the Userid");
	String userid = s.next();
	System.out.println("Enter the Password");
	String pwd = s.next();
	Class.forName("org.postgresql.Driver");
	System.out.println("Driver Loaded..");
	// Step - 2 Connect to the DB
	// jdbc:postgresql://localhost:5432/exam
	// http://www.google.com
	Connection con = DriverManager.
			getConnection("jdbc:postgresql://localhost:5432/exam"
					,"amit","amit123");
	if(con!=null){
		System.out.println("Connection Created...");
	}
	final String SQL="select userid, password from users where userid=? and password=?";
	// Step- 3 Query
	PreparedStatement pstmt = con.prepareStatement(SQL);
	pstmt.setString(1, userid);
	pstmt.setString(2, pwd);
	// Step-4 Get the Result
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()){
		System.out.println("Welcome "+userid);
	}
	else{
		System.out.println("Invalid Userid or Password");
	}
	// Step -5 Close the Resources
	rs.close();
	pstmt.close();
	con.close();

} */
}








