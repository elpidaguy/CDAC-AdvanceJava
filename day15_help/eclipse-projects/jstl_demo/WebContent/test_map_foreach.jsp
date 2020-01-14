<%@page import="java.util.HashMap"%>
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
	<%
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("abc", 12377);
		hm.put("abc1", 1234);
		hm.put("abc123", 123456);
	%>
	<c:set var="test" value="<%=hm%>" />
	<h4>${test}</h4>
	<br />
	<hr />
	<c:forEach var="entry" items="${test}">
		<h4>${entry.key} ${entry.value}</h4>
	</c:forEach>
</body>
</html>