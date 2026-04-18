package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Appointment;
import com.project.util.DBConnection;

public class AppointmentDao {

    public boolean bookAppointment(int patientId, int doctorId,String doctorName,
                                   String date, String time) {

        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

    
            String checkQuery = "SELECT * FROM appointments WHERE doctor_id=? AND appointment_date=? AND appointment_time=? AND status='Booked'";

            PreparedStatement checkPs = con.prepareStatement(checkQuery);
            checkPs.setInt(1, doctorId);
            checkPs.setString(2, date);
            checkPs.setString(3, time);

            ResultSet rs = checkPs.executeQuery();

  
            if (rs.next()) {
                return false;
            }

     
            String insertQuery = "INSERT INTO appointments(patient_id, doctor_id, doctor_name, appointment_date, appointment_time, status) VALUES (?, ?,?, ?, ?, ?)";

            PreparedStatement insertPs = con.prepareStatement(insertQuery);

            insertPs.setInt(1, patientId);
            insertPs.setInt(2, doctorId);
            insertPs.setString(3, doctorName);
            insertPs.setString(4, date);
            insertPs.setString(5, time);
            insertPs.setString(6, "Booked");

            int row = insertPs.executeUpdate();

            if (row > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    public static List<Appointment> getAppointmentsByEmail(int patientId){
    	
    	List<Appointment> list = new ArrayList<>();
    	
    	try {
    		Connection con = DBConnection.getConnection();
    		String q = "SELECT * FROM appointments WHERE patient_id = ?";
    		PreparedStatement ps = con.prepareStatement(q);
    		ps.setInt(1, patientId);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			Appointment a = new Appointment();
    			
    			a.setId(rs.getInt("id"));
    			a.setDoctorName(rs.getString("doctor_name"));
    			a.setAppointmentDate(rs.getString("appointment_date"));
                a.setAppointmentTime(rs.getString("appointment_time"));
                a.setStatus(rs.getString("status"));
                
                list.add(a);

    			
    		}
    	} catch(Exception e) {
    		
    		e.printStackTrace();
    	}
    	
    	return list;
    }
    
    
    public static void cancelAppointment(int id) {
    	
    	try {
    		
    		Connection con = DBConnection.getConnection();
    		
    		String q = "UPDATE appointments SET status='Cancelled' wher id=?";
    		PreparedStatement ps = con.prepareStatement(q);
    		
    		ps.setInt(1, id);
    		ps.executeUpdate();
    	}  catch(Exception e) {
    		
    		e.printStackTrace();
    	}
    
    
    
    }
    
    public static Appointment getLatestAppointment(int userId) {
    	
    	Appointment a = null;
    	
    	try {
    		
    		Connection con = DBConnection.getConnection();
    		
    		String q = "SELECT * FROM appointments WHERE patient_id=? ORDER BY id DESC LIMIT 1";
    		
    		PreparedStatement ps = con.prepareStatement(q);
    		
    		ps.setInt(1, userId);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			
    			a = new Appointment();
    			a.setId(rs.getInt("id"));
                a.setDoctorName(rs.getString("doctor_name"));
                a.setAppointmentDate(rs.getString("appointment_date"));
                a.setAppointmentTime(rs.getString("appointment_time"));
                a.setStatus(rs.getString("status"));
    			
    		}
    		
    	} catch (Exception e ) {
    		e.printStackTrace();
    	}
    	
    	return a;
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}