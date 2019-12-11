<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register New Employee</title>
</head>
<body>
	<sp:form method="post" modelAttribute="employee">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter Employee Name</td>
				<td><sp:input type="name" path="empName" /></td>
			</tr>
			<tr>
				<td>Enter Employee Email</td>
				<td><sp:input type="name" path="email" /></td>
			</tr>
			<tr>
				<td>Enter Salary</td>
				<td><sp:input type="number" path="salary" /></td>
			</tr>
			<tr>
				<td>Enter Date of Birth</td>
				<td><sp:input type="date" path="DOB" /></td>
			</tr>
			

			<tr>
				<td><input type="submit" value="Hire" /></td>
			</tr>
			
			<tr><h1 style="color: red">${requestScope.msg}</h1></tr>
		</table>
	</sp:form>

</body>
</html>