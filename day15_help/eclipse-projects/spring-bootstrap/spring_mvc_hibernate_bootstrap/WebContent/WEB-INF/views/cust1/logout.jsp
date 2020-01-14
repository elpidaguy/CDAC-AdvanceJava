<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh"
	content="6;url=${pageContext.request.contextPath}">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello , ${requestScope.cust_dtls.name}</h3>
	<h3>Logged out successfully, will be taken shortly to login
		page...</h3>
</body>
</html>