<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login Page</title>
</head>
<body>
	<h1> Welcome to this demo login page! </h1>
	
	<c:if test="$(not empty loginError)">
		<p>${loginError }</p>
	</c:if>
	<p>${customLoginAttribute}</p>
	<form action="j_spring_security_check" name="myLoginForm" method="post">
		<label>User Name: </label> <input type="text" name="j_username" value=""/>
		<label>Password: </label> <input type="password" name="j_password" />
		<input type="submit" name="submit" value="Get Started">
	</form>
</body>
</html>