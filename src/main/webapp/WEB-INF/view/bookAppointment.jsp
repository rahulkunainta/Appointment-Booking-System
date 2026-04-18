<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Appointment</title>
<link rel="stylesheet" href="css/bookAppointment.css">
</head>
<body>

    <div class="booking-container">
        <div class="booking-card">
            <h2>Book Your Appointment</h2>
            <p>Please choose your preferred date and time</p>

            <form action="ConfirmAppointmentServlet" method="post">

                <input type="hidden" name="doctorId" value="${doctorId}">
                <input type="hidden" name="doctorName" value="${doctorName}">

                <label>Select Date</label>
                <input type="date" name="appointmentDate" required>

                <label>Select Time</label>
                <input type="time" name="appointmentTime" required>

                <button type="submit">Confirm Booking</button>
            </form>

            <a href="DoctorServlet" class="back-btn">Back to Doctors</a>
        </div>
    </div>

</body>
</html>
