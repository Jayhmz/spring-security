<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hi ${username }</h1>
	<h4>${authority}</h4>
	This is a good homepage  </br></br>
	<a href="/springsecurity/admin">Admin Page</a>
	</br>
	</br>
	<a href="/springsecurity/user">User Page</a>
	
	<form:form action="logout" method="post">
		<input type="submit" value="logout" />
	</form:form>
</body>
</html>