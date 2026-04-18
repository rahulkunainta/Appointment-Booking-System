<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Dashboard</title>
<link rel="stylesheet" href="css/dashboard.css">
</head>
<body>

<div class="navbar">
    <h2>Doctor Dashboard</h2>
    <div class="nav-links">
        <a href="#">Home</a>
        <a href="#">Appointments</a>
        <a href="#">Profile</a>
        <a href="index.jsp">Logout</a>
    </div>
</div>

<c:if test="${empty sessionScope.username}">
    <c:redirect url="/index.jsp"/>
</c:if>

<div class="dashboard-container">

<!-- HERO -->
<div class="hero-container" style="background-image:url('${pageContext.request.contextPath}/Pictures/heroBackground.jpg'); background-size:cover;">
    <div class="hero-text">
        <h3>Welcome, ${sessionScope.username} 👋</h3>
        <h1>
            Get Better <span class="highlight">Care</span>,
            <span class="highlight2">For Your</span> Health
        </h1>

        <ul class="features">
            <li>✔ Reduce scheduling mistakes</li>
            <li>✔ Improve patient coordination</li>
            <li>✔ Secure sensitive information</li>
        </ul>

        <div class="hero-buttons">
            <p>Need a doctor today?</p>
            <a href="DoctorServlet" class="book-btn1">Book Appointment</a>
            <a href="#" class="secondary-btn">View Plans</a>
        </div>
    </div>
</div>

<!-- SPECIALITY -->
<div class="speciality-section">
    <div class="section-header">
        <h2>Select a Speciality to See Available Doctors</h2>
        <a href="DoctorServlet" class="view-all-btn">View All</a>
    </div>

    <div class="speciality-grid">
        <div class="speciality-card">
            <img src="images/general.png">
            <p>General Practitioner</p>
            <a href="doctors.jsp">Book Now</a>
        </div>

        <div class="speciality-card">
            <img src="images/dentist.png">
            <p>Dentist</p>
            <a href="doctors.jsp">Book Now</a>
        </div>

        <div class="speciality-card">
            <img src="images/ortho.png">
            <p>Orthopedics</p>
            <a href="doctors.jsp">Book Now</a>
        </div>

        <div class="speciality-card">
            <img src="images/pediatric.png">
            <p>Pediatrics</p>
            <a href="doctors.jsp">Book Now</a>
        </div>

        <div class="speciality-card">
            <img src="images/cardio.png">
            <p>Cardiology</p>
            <a href="doctors.jsp">Book Now</a>
        </div>

        <div class="speciality-card">
            <img src="images/psychology.png">
            <p>Psychology</p>
            <a href="doctors.jsp">Book Now</a>
        </div>
    </div>
</div>

<!-- APPOINTMENTS -->
<div class="appointment-container">

    <!-- PROFILE -->
    <div class="left1-appointment">
        <div class="card profile-card" style="background-image:url('${pageContext.request.contextPath}/Pictures/back5.jpg');">
            <img src="${pageContext.request.contextPath}/Pictures/profile.jpg">
            <h3>My Profile</h3>
            <p>Name: ${sessionScope.username}</p>
            <p>Email: ${sessionScope.useremail}</p>
        </div>
    </div>

    <!-- UPCOMING -->
    <div class="left-appointment">
        <c:choose>
            <c:when test="${not empty appointment}">
                <div class="card appointment-card" style="background-image:url('${pageContext.request.contextPath}/Pictures/back4.jpg');">
                    <h3>Upcoming Appointment</h3>
                    <p>Doctor Name: ${appointment.doctorName}</p>
                    <p>Date: ${appointment.appointmentDate}</p>
                    <p>Time: ${appointment.appointmentTime}</p>
                    <p>Status:
                        <span class="${appointment.status == 'Booked' ? 'status-green' : 'status-red'}">
                            ${appointment.status}
                        </span>
                    </p>
                </div>
            </c:when>

            <c:otherwise>
                <div class="card appointment-card">
                    <h3>Upcoming Appointment</h3>
                    <p>No appointment booked yet</p>
                    <a href="DoctorServlet" class="book-btn">Book Now</a>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <!-- MY APPOINTMENTS -->
    <div class="right-appointment">
        <div class="card my-appo-card" style="background-image:url('${pageContext.request.contextPath}/Pictures/back2.jpg');">
            <h3>My Appointment</h3>

            <c:if test="${not empty appointment}">
                <p>${appointment.appointmentDate} - ${appointment.appointmentTime}</p>
                <a href="AllAppointmentsServlet" class="book-btn">Show All Appointments</a>
            </c:if>

            <c:if test="${empty appointment}">
                <p>No records found</p>
            </c:if>
        </div>
    </div>

    <!-- STATS -->
    <div class="right2-appointment">
        <div class="card stats-card" style="background-image:url('${pageContext.request.contextPath}/Pictures/back6.jpg'); padding:20px; color:#fff;">
            <h3>Quick Stats :</h3>

            <p><strong>Total Appointments:</strong> 4</p>
            <p><strong>Doctors Available:</strong> 12</p>
            <p><strong>Departments:</strong> 6</p>
            <p><strong>Patients Today:</strong> 18</p>
            <p><strong>Pending Appointments:</strong> 2</p>
            <p><strong>Completed Appointments:</strong> 2</p>

            <hr>

            <h4>Today's Highlights</h4>
            <p>🕒 Next Appointment: 11:30 AM</p>
            <p>👨‍⚕️ On Duty Doctor: Dr. Sharma</p>

            <hr>

            <h4>Quick Actions</h4>
            <a href="DoctorServlet"><button>Book Appointment</button></a>
            <a href="DoctorServlet"><button>View Doctors</button></a>
        </div>
    </div>

</div>

<!-- GALLERY -->
<div class="gallery-section">
    <h2>Gallery</h2>

    <div class="gallery-grid">
        <img src="${pageContext.request.contextPath}/Pictures/p1.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p2.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p3.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p4.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p5.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p6.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p7.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p8.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p9.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p10.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p11.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p12.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p13.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p14.jpg">
        <img src="${pageContext.request.contextPath}/Pictures/p15.jpg">
    </div>
</div>

</div>

<!-- FOOTER -->
<footer class="footer">
    <div class="footer-content">
        <p>© 2026 All Rights Reserved</p>
        <p>Created by <span class="author">Rahul Kunainta</span></p>
    </div>
</footer>

</body>
</html>