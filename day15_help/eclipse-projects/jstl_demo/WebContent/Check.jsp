
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<form>
		Enter The number :<input type="text" name="no1"> <input
			type="submit" value="Check">
	</form>


	<c:if test="${!empty param.no1}">

		<c:set var="a" value="${param.no1}" />

		<c:if test="${ a%2 ==0 }">
			<h3>It is a even number....</h3>
		</c:if>

		<c:if test="${ a%2 !=0 }">
			<h3>It is a odd number....</h3>
		</c:if>

	</c:if>