<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<form action="RegisterServlet" method="post">
    
    <label>Name</label>
    <input type="text" name="name" placeholder="Enter your name" required>
    <br><br>

    <label>Email</label>
    <input type="email" name="email" placeholder="Enter your email" required>
    <br><br>

    <label>Password</label>
    <input type="password" name="password" placeholder="Enter password" required>
    <br><br>

    <input type="submit" value="Create Account">

</form>

</body>
</html>