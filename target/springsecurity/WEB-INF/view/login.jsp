<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.error != null }">
		<i style="color: red;">Error login in with details, kindly check
			your credentials or create an account</i>
	</c:if>
	<div align="center">
		<h3>Custom Login Page</h3>
		<form:form >
		Name : <input name="username" />
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