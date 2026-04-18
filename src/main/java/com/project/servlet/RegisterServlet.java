package com.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.PatientDao;
import com.project.model.Patient;
 
public class RegisterServlet extends HttpServlet {
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Patient p = new Patient();
		
		p.setName(name);
		p.setEmail(email);
		p.setPassword(password);
		
		PatientDao dao = new PatientDao();
		
		boolean status = dao.registerPatient(p);
		
		if(status) {
			response.sendRedirect("index.jsp");
		}else {
            response.getWriter().println("Registration Failed");
        }
	 
	}

}
