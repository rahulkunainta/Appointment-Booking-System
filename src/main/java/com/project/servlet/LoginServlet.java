package com.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.PatientDao;
import com.project.model.Patient;
 
public class LoginServlet extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
			
		PatientDao dao = new PatientDao();
//		boolean status = dao.loginPatient(email,password);
//		
//		if(status) {
//			 request.getRequestDispatcher("WEB-INF/view/dashboard.jsp").forward(request, response);
//        } else {
//            response.getWriter().println("Invalid Login");
//        }
//		
 	 
		
		Patient p = dao.getPaatientByLogin(email, password);
		
		if(p != null) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("username", p.getName());
			session.setAttribute("useremail" , p.getEmail());
			session.setAttribute("patientId", p.getId());
			
			request.getRequestDispatcher("DashboardServlet")
	           .forward(request, response);
			
			
		} else {
            response.getWriter().println("Invalid Login");
      }
				
		
		
		
	}

}
