<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
Username<input type="text" name="username"><br><br>
Password<input type="password" name="password"><br><br>
<input type="submit" value="Submit">
</form>
</body>
</html>