<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Login Successful</h3>
	<h3>Customer Details : ${sessionScope.cust_dtls}</h3>
	<a href="<c:url value='/cust/logout'/>">Log Me Out</a>
</body>
</html>