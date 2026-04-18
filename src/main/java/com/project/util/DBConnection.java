package com.project.util;

import java.sql.*;

public class DBConnection {
	
	public static Connection getConnection () {
		Connection con = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
    "jdbc:mysql://roundhouse.proxy.rlwy.net:53520/railway",
    System.getenv("root"),
    System.getenv("OAVwGuYkahxNJFIYrlBxTKYEHSsKUbOD")
);
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return con;
		
	}

}
