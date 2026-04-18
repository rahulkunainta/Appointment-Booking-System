package com.project.util;

import java.sql.*;

public class DBConnection {
	
	public static Connection getConnection () {
		Connection con = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
    "jdbc:mysql://"+System.getenv("mysql.railway.internal")+":"+System.getenv("3306")+"/"+System.getenv("railway"),
    System.getenv("root"),
    System.getenv("OAVwGuYkahxNJFIYrlBxTKYEHSsKUbOD")
);
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return con;
		
	}

}
