package com.brainmentors.testengine.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class A{
	static{
		System.out.println("A Class Loaded...");
	}
}

public class UserDAO {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
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

}
}








