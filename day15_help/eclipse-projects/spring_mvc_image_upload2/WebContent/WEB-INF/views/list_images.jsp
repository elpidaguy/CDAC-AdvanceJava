<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<spring:url var="url" value="choose" />
	<h3 align="center">Choose Image</h3>
	<form method="post" action="${url}">

		<table style="background-color: cyan; margin: auto;" border="1">
			<c:forEach var="img" items="${requestScope.image_list}">
				<tr>
					<td><input type="radio" name="imgName" 
					value="${img}" />${img}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="Choose" /></td>
			</tr>
		</table>

	</form>
</body>
</html>