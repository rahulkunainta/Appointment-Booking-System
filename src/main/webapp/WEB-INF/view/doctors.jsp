<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Doctors</title>
<link rel="stylesheet" href="css/doctors.css">
</head>
<body>

    <div class="navbar">
        <h2>Available Doctors</h2>
        <a href="/WEB-INF/view/dashboard.jsp">Back to Dashboard</a>
    </div>

    <div class="doctor-container">

        <c:forEach var="doc" items="${doctorList}">
            <div class="doctor-card">
                <h3>Dr. ${doc.name}</h3>
                <p><strong>Specialization:</strong> ${doc.specialization}</p>
                <p><strong>Experience:</strong> ${doc.experience} years</p>
                <p><strong>Fees:</strong> ₹${doc.fees}</p>
                <p><strong>Available:</strong> ${doc.availableTime}</p>

                <form action="BookAppointmentServlet" method="post">
                    <input type="hidden" name="doctorId" value="${doc.id}">
                    <input type="hidden" name="doctorName" value="${doc.name}">
                    <button type="submit">Book Appointment</button>
                </form>
            </div>
        </c:forEach>

    </div>

</body>
</html>
