<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File Upload</title>
</head>
<body>
	<form action="handleForm" method="post" enctype="multipart/form-data">
		<input type="file" name="file" />
		<input type="submit" />
	</form>
</body>
</html>