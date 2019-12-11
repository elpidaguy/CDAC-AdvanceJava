<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>${sessionScope.voter.status}</h4>
	<h4>${sessionScope.voter.message}</h4>
	<c:if test="${!sessionScope.voter.details.status}">
		<%--set property cid n invoke B.L methods --%>
		<jsp:setProperty property="*" name="candidate" />
		<h4>${sessionScope.candidate.updateVotes()}</h4>
		<h4>${sessionScope.voter.updateStatus()}</h4>
	</c:if>

	<%--invalidate session --%>
	${pageContext.session.invalidate()}
	<h5>
		<a href="login.jsp">Visit Again</a>
	</h5>
</body>
</html>