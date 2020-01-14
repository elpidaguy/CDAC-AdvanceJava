<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Complaint Form</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	
 
	<form:form modelAttribute="complaint">
		<table>
			<tr>
				<td>Enter Customer Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Enter Customer password</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Enter Name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Choose City</td>
				<td><form:select path="city" items="${applicationData.cities}" /></td>
				<td><form:errors path="city" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>Choose OS</td>
				<td><form:select path="platform" items="${applicationData.platforms}" /></td>
				<td><form:errors path="platform" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Choose Technologies</td>
				<td><form:checkboxes items="${applicationData.technologies}"
						path="techno" />
				<td><form:errors path="techno" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Choose Browser</td>
				<td><form:radiobuttons items="${applicationData.browsers}"
						path="browser" />
				<td><form:errors path="browser" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Enter Complaint Description</td>
				<td><form:textarea path="complaintDesc" /></td>
				<td><form:errors path="complaintDesc" cssClass="error" /></td>
			</tr>
			
			

			<tr>
				<td><input type="submit" value="Register Complaint" /></td>
			</tr>
		</table>
	</form:form>


</body>
</html>