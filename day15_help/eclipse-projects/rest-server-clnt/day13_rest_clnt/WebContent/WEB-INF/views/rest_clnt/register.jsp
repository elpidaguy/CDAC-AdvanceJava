<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<sf:form method="post" modelAttribute="studentDTO">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter  Name</td>
				<td><sf:input path="name" /></td>
				<td><sf:errors path="name" /></td>
			</tr>
			<tr>
				<td>Enter  Email</td>
				<td><sf:input type="email" path="email" /></td>
				<td><sf:errors  path="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><sf:password path="password" /></td>
				<td><sf:errors  path="password" /></td>
			</tr>
			<tr>
				<td>Enter Fees</td>
				<td><sf:input type="number" path="fees" /></td>
				<td><sf:errors  path="fees" /></td>
			</tr>
			<tr>
				<td>Enter DOB</td>
				<td><sf:input type="date" path="dob" /></td>
				<td><sf:errors  path="dob" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="btn" value="Register Student" /></td>
			</tr>
		</table>
	</sf:form>



</body>
</html>