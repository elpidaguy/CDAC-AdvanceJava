<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">${requestScope.mesg}</h3>
	<form:form modelAttribute="customer" method="post">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:password path="pass" /></td>
			</tr>
			<tr>
				<td>Enter Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Enter Role</td>
				<td><form:input path="role" /></td>
			</tr>
			<tr>
				<td>Enter Reg Amount</td>
				<td><form:input path="regAmount" /></td>
			</tr>
			<tr>
				<td>Enter Reg Date</td>
				<td><form:input path="regDate" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Reg Me" /></td>
				

			</tr>
		</table>
	</form:form>

</body>
</html>