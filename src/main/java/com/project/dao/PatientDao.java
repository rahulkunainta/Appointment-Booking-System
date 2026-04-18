package com.project.dao;

import java.sql.Connection;

import com.project.model.Patient;
import com.project.util.DBConnection;
import java.sql.*;

public class PatientDao {
	
	public boolean registerPatient(Patient p) {
		
		boolean status = false;
		
		try {
			Connection con = DBConnection.getConnection();
			
			String q = "INSERT INTO patients(name,email,password) VALUES(?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(q);
			
			ps.setString(1,p.getName());
			ps.setString(2, p.getEmail());
			ps.setString(3, p.getPassword());
			
			int rows = ps.executeUpdate();
			
			if (rows > 0) {
				status = true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
//	public boolean loginPatient(String email,String password) {
//		boolean status = false;
//		
//		try {
//			
//			Connection con = DBConnection.getConnection();
//			
//			String q = "SELECT * FROM patients WHERE email=? AND password=?";
//			
//			PreparedStatement ps = con.prepareStatement(q);
//			
//			ps.setString(1, email);
//			ps.setString(2, password);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				status = true;
//			}
//		
//		} catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//	    return status;
//	}
	
	
	
	public Patient getPaatientByLogin(String email, String password) {
		
		Patient p = null;
		
		try {
			 Connection con = DBConnection.getConnection();
			 
			 String q = "SELECT * FROM patients WHERE email=? AND password=?";
			 
			 PreparedStatement ps = con.prepareStatement(q);
			 ps.setString(1, email);
			 ps.setString(2, password);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 if(rs.next()) {
				 p = new Patient();
				 p.setId(rs.getInt("id"));
				 p.setName(rs.getString("name"));
				 p.setEmail(rs.getString("email"));
				 p.setPassword(rs.getString("password"));
			 }
 
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return p;
		
	}

}
