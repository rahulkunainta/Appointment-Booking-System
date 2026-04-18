package com.project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.DoctorDao;
import com.project.model.Doctor;
 
public class DoctorServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DoctorDao dao = new DoctorDao();
		
		List<Doctor> doctorList = dao.getAllDoctors();
		
		request.setAttribute("doctorList", doctorList);
		 request.getRequestDispatcher("/WEB-INF/view/doctors.jsp")
         .forward(request, response);
		
		
		 
	}
 
}
