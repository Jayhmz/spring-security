<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>Custom Register Page</h3>
		<form:form action="process-signup" method="POST" modelAttribute="user">
		Name : <input name="username" />
			<br>
			<br>
		Email : <input name="email" />
			<br>
			<br>
		Password : <input name="password" />
			<br>
			<br>
			<input type="submit" value="SUBMIT" />
		</form:form>
		<br>
	</div>
</body>
</html>