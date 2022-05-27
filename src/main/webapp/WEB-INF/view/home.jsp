<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	<h1>Hi ${user }</h1>
	<h4>${roles}</h4>
	This is a good homepage  </br></br>
	
	<sec:authorize access="hasAuthority('admin')">
	<a href="/springsecurity/admin">Admin Page</a>
	</sec:authorize>
	</br> </br> 
	
	<sec:authorize access="hasAuthority('user')">
	<a href="/springsecurity/user">User Page</a>
	</sec:authorize>
	
	<br />
	<br />
	
	<a href="/springsecurity/change-password">change password</a>  
	
	<form:form action="logout" method="post">
		<input type="submit" value="logout" />
	</form:form>
	 
</body>
</html>