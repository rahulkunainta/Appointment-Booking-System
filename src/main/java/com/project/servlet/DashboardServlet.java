package com.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.AppointmentDao;
import com.project.model.Appointment;
 
public class DashboardServlet extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		HttpSession session = request.getSession();
		
		int userId = (Integer)session.getAttribute("patientId");
		
		Appointment a = AppointmentDao.getLatestAppointment(userId);
		
		request.setAttribute("appointment",a);
		
		request.getRequestDispatcher("/WEB-INF/view/dashboard.jsp")
        .forward(request, response);
		
		
		
		
		
		
	}

	 

}
