package com.project.util;

import java.sql.*;

public class DBConnection {
	
	public static Connection getConnection () {
		Connection con = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("mysql://root:OAVwGuYkahxNJFIYrlBxTKYEHSsKUbOD@mysql.railway.internal:3306/railway","mysql.railway.internal","OAVwGuYkahxNJFIYrlBxTKYEHSsKUbOD");
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return con;
		
	}

}
