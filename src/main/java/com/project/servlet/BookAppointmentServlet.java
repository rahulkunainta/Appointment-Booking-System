package com.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class BookAppointmentServlet extends HttpServlet {
	 
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int id = Integer.parseInt(request.getParameter("doctorId"));
		String name = request.getParameter("doctorName");
		
		 
		request.setAttribute("doctorId", id);
		request.setAttribute("doctorName", name);
		
		request.getRequestDispatcher("WEB-INF/view/bookAppointment.jsp").forward(request,response);
		 
	}

}
