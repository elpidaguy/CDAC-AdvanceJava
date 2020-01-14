<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>${requestScope.mesg}</h4>
	<h5>Hello , ${sessionScope.user_dtls.name}</h5>
	<form method="post" action="<spring:url value='/account/close'/>">
		<table style="background-color: cyan; margin: auto;" border="1">

			<caption>A/C Summary</caption>
			<tr>
				<th></th>
				<th>A/C No</th>
				<th>Type</th>
				<th>Balance</th>
			</tr>
			<c:forEach var="a" items="${sessionScope.user_dtls.accounts}">
				<tr>
					<td><input type="radio" name="acId" value="${a.id}"></td>
					<td>${a.id}</td>
					<td>${a.acType}</td>
					<td>${a.balance}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="Close A/C"></td>
			</tr>
		</table>
	</form>
	<h5>
		<a href="<spring:url value='/account/create'/>">Create New Account</a>
	</h5>
	<h5>
		<a href="<spring:url value='/user/logout'/>">Log Me Out</a>
	</h5>
</body>
</html>