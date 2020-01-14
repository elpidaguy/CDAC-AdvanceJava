<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">Customer List</h3>
	<c:forEach var="cust" items="${requestScope.cust_list}">
     ${cust.email} ${cust.name} ${cust.depositAmt} <fmt:formatDate
			pattern="dd-MM-yyyy" value="${cust.regDate}" />
		<br />
	</c:forEach>
</body>
</html>