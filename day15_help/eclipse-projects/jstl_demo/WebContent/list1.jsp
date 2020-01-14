<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String[] nms = { "a", "b", "c" };
	int len = nms.length;
	int[] ids = { 10, 20, 30 };
%>
<c:set var="nms" value="<%=nms%>" />
<c:set var="ids" value="<%=ids%>" />
<body>
	<c:forEach var="abc" begin="0" end="<%=len%>" step="1">

		<c:url var="url1" value="details.jsp">

			<c:param name="id" value="${ids[abc]}" />
		</c:url>
		<a href="${url1}">${nms[abc]}</a>
		<br />

	</c:forEach>
</body>
</html>