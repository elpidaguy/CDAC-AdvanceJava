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
	<h3 style="color: cyan;">${sessionScope.voter.message},
		${sessionScope.voter.details.email}</h3>
	<h4 align="center">Candidate List</h4>
	<form action="status.jsp" method="post">
		<table style="background-color: cyan; margin: auto;" border="1">
			<c:forEach var="c" items="${sessionScope.candidate.listCandidates()}">
				<tr>
					<td><input type="radio" name="cId" value="${c.id}"></td>
					<td>${c.name}</td>
					<td>${c.party}</td>
				</tr>
			</c:forEach>

			<tr>
				<td><input type="submit" value="Vote" /></td>
			</tr>
		</table>
	</form>

</body>
</html>