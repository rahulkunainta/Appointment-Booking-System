package com.project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.AppointmentDao;
import com.project.model.Appointment;

 
public class AllAppointmentsServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("patientId");
		
		
		List<Appointment> list = AppointmentDao.getAppointmentsByEmail(userId);
		
		request.setAttribute("appointments", list );
		
		request.getRequestDispatcher("/WEB-INF/view/allAppointments.jsp").forward(request,response);
		
		 
	}

	 

}
