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
<h3>${sessionScope.voter.status}</h3>
	<h3>Party-wise Votes Analysis</h3>
	<table style="background-color: cyan; margin: auto;" border="1">
		<tr>
			<td>Party</td>
			<td>Votes</td>
		</tr>
		<c:forEach var="a" items="${sessionScope.candidate.votesAnalysis()}">
			<tr>
				<td>${a.politicalParty}</td>
				<td>${a.votes}</td>
			</tr>
		</c:forEach>
	</table>
	<h3>Top 2 Candidates</h3>
	<table style="background-color: cyan; margin: auto;" border="1">
		<tr>
			<td>Name</td>
			<td>Votes</td>
		</tr>
		<c:forEach var="c" items="${sessionScope.candidate.topNAnalysis()}">
			<tr>
				<td>${c.name}</td>
				<td>${c.votes}</td>
			</tr>
		</c:forEach>
	</table>
	${pageContext.session.invalidate()}
	<h4>You have logged out successfully....</h4>
	<h5>
		<a href="login.jsp">Voter Login</a>
	</h5>
</body>
</html>