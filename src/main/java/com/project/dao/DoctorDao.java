package com.project.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.project.model.Doctor;
import com.project.util.DBConnection;

public class DoctorDao {
	
	public List<Doctor> getAllDoctors(){
		
		List<Doctor> doctorList = new ArrayList<>();
		
		try {
			
			Connection con = DBConnection.getConnection();
			
			String q = "SELECT * FROM doctors";
			
			PreparedStatement ps = con.prepareStatement(q);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Doctor doc = new Doctor();
				doc.setId(rs.getInt("id"));
				doc.setName(rs.getString("name"));
				doc.setSpecialization(rs.getString("specialization"));
				doc.setExperience(rs.getInt("experience"));
                doc.setFees(rs.getDouble("fees"));
                doc.setAvailableTime(rs.getString("available_time"));
				
                doctorList.add(doc);
				
				
			}
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return doctorList;
		
		
		
		
	}
	

}
