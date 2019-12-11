<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Candidates</title>
</head>
<body>
	<h4>${requestScope.msg}</h4>
	<h4>${requestScope.candidateList}</h4>
	
	<h3 style="color: cyan;">${sessionScope.msg}</h3>
	<h4 align="center">Candidate List</h4>
	<form action="processVote" method="post">
		<table style="background-color: cyan; padding:10px ;margin: auto;" border="1">
			<c:forEach var="c" items="${requestScope.candidateList}">
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