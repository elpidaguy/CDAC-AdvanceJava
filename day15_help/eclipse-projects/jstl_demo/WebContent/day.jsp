<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL choose,when,otherwise</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>

	<form>
		Enter The Day No :<input type="text" name="day"> <input
			type="submit" value="Check">
	</form>
	<c:if test="${!empty param.day}">
		<c:set var="a" value="${param.day}" />
		<c:choose>
			<c:when test="${ a==1 }">Sunday </c:when>
			<c:when test="${ a==2 }">Monday  </c:when>
			<c:when test="${ a==3 }">Tuesday  </c:when>
			<c:otherwise>Some other day...</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>
