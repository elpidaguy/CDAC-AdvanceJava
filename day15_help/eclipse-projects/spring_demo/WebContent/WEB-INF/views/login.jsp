<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<spring:url value='/css/main.css'/>"
	type="text/css" />
</head>
<body>


	<h3 align="center">${mesg}</h3>
	<h3 align="center">
		<spring:message code="user.mesg" />
	</h3>

	<form:form method="post" modelAttribute="customer">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td><spring:message code="user.email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors cssClass="err" path="email" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.password" /></td>
				<td><form:password path="password" /></td>
				<td><form:errors cssClass="err" path="password" /></td>
			</tr>
			<tr>
				<td><input type="submit"
					value="<spring:message code="user.submit" />" /></td>
			</tr>
		</table>
	</form:form>
	<h3 align="center">
		<spring:url var="url" value="">
			<spring:param name="locale123">en</spring:param>
		</spring:url>
		<a href="${url}">English</a>
	</h3>
	<h3 align="center">
		<spring:url var="url" value="">
			<spring:param name="locale123">mr_IN</spring:param>
		</spring:url>
		<a href="${url}">मराठी</a>
	</h3>

</body>
</html>