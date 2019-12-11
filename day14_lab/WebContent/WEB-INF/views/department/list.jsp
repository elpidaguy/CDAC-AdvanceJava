<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Departments</title>
</head>
<body>

	<table style="padding: 20px;margin: auto; background-color: cyan;" border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Department Name</th>
				<th>Location</th>
				<th>Strength</th>
				<th>Options</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.deptList}" var="dept">

				<tr>
					<td>${dept.id}</td>
					<td>${dept.deptName}</td>
					<td>${dept.location}</td>
					<td>${dept.empList.size()}/${dept.strength}</td>
					<td> <a href="<spring:url value='/employee/register?deptId=${dept.id}' />" > View </a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<%-- 	${requestScope.deptList} --%>

</body>
</html>