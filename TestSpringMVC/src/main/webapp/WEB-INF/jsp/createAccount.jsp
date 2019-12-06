<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
	.error{
		color: red;
		font-size: 15px;
	}
</style>
<title>Create Account</title>
</head>
<body>
	<h1>Enter Account Details</h1>
	<sform:form modelAttribute="aNewAccount" action="doCreate" method="post">
		<table>
			<tr>
				<td>First Name: <sform:input path="firstName" type="text"
						name="firstName" />
					<sform:errors path="firstName" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td>Last Name: <sform:input path="lastName" type="text"
						name="lastName" /></td>
					<sform:errors path="lastName" cssClass="error"/>
			</tr>
			<tr>
				<td>
					Age: <sform:input path="age" type="text" name="age" />
					<sform:errors path="age" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td>Address: <sform:input path="address" type="text"
						name="address" />
					<sform:errors path="address" cssClass="error"/>
						</td>
			</tr>
			<tr>
				<td>Email: <sform:input path="email" type="text" name="email" />
				<sform:errors path="email" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Create" /></td>
			</tr>
		</table>
	</sform:form>

</body>
</html>