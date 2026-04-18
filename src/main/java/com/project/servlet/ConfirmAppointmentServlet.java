package com.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.project.dao.AppointmentDao;
import com.project.model.Appointment;

public class ConfirmAppointmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        int patientId = (int) session.getAttribute("patientId");

        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        String doctorName = request.getParameter("doctorName");
        
     

        String date = request.getParameter("appointmentDate");
        String time = request.getParameter("appointmentTime");

        AppointmentDao dao = new AppointmentDao();

        boolean status = dao.bookAppointment(
                patientId,
                doctorId,
                doctorName,
                date,
                time
        );

        if (status) {
        	
        	Appointment ap = new Appointment();

        	ap.setDoctorId(doctorId);
        	ap.setDoctorName(doctorName);
        	ap.setAppointmentDate(date);
        	ap.setAppointmentTime(time);
        	ap.setStatus("Booked");
        	
        	request.setAttribute("appointment",ap);
        	
        	request.getRequestDispatcher("/WEB-INF/view/dashboard.jsp")
            .forward(request, response);
        } else {
            response.getWriter().println("Slot not available");
        }
    }
}