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
<a href="${pageContext.request.contextPath}/display">Display Employees</a>
<table border="1"> <br/><br/>
<tr>
<th>Eno</th>
<th>Name</th>
<th>Address</th>
</tr>
<c:forEach var="emp" items="${requestScope.employees}">
<tr>
<td>${emp.eno}</td>
<td>${emp.name}</td>
<td>${emp.address}</td>
</tr>
</c:forEach>

</table>
</body>
</html>