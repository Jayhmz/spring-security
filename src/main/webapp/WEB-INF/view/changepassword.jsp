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



	<div align="center">
		<h3>Recover Password Page</h3>
	
		<c:if test="${param.PasswordMatchFailure != null }">
			<p style="color:red;">Check new and confirm password again...</p>
		</c:if>
		<c:if test="${param.incorrectpassword != null }">
			<p>Wrong old password.</p>
		</c:if>
		<form:form action="" method="POST" modelAttribute="cpDTO">
		
		Password : <input name="oldpassword" />
			<br>
			<br>
		New Password : <input name="newpassword" />
			<br>
			<br>
		
		Confirm Password : <input name="confirmpassword" />
			<br>
			<br>
			<input type="submit" value="SUBMIT" />
		</form:form>
		<br>
	</div>
</body>
</html>