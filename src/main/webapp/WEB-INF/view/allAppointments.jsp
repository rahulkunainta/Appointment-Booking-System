<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Appointments</title>
    <link rel="stylesheet" href="css/allAppointments.css">
</head>
<body>

<div class="navbar">
    <h2>My Appointments</h2>
    <a href="<c:url value='/DashboardServlet'/>" class="back-btn">← Back</a>
</div>

<div class="container">

    <c:if test="${empty appointments}">
        <p class="no-data">No appointments found</p>
    </c:if>

    <c:forEach var="a" items="${appointments}">
        <div class="card">

            <div class="card-header">
                <h3>${a.doctorName}</h3>
                <span class="status ${a.status}">${a.status}</span>
            </div>

            <div class="card-body">
                <p><strong>Date:</strong> ${a.appointmentDate}</p>
                <p><strong>Time:</strong> ${a.appointmentTime}</p>
            </div>

            <div class="card-footer">
                <form action="CancelAppointmentServlet" method="post">
                    <input type="hidden" name="id" value="${a.id}">
                    <button type="submit" class="cancel-btn">Cancel</button>
                </form>
            </div>

        </div>
    </c:forEach>

</div>

</body>
</html>