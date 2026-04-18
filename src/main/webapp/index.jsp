<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appointment-Booking-Using-JavaEE</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

    <form action="LoginServlet" method="post">
    
    <label for="email">Email</label><br>
    <input type="email" id="email" name="email" placeholder="Enter email" required>
    <br><br>

    <label for="password">Password</label><br>
    <input type="password" id="password" name="password" placeholder="Enter password" required>
    <br><br>

    <input type="submit" value="Login">
    <br><br>

    <a href="Register.jsp">Create New Account</a>

</form>

</body>
</html>