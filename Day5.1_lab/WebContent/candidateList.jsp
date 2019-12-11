<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>




<body class="container">
<div class="mt-4 p-2">
	<h3>Vote for India</h3><hr>
</div>
	<div class="row align-items-center">
		<div class="col-md-6">
		<form action="status.jsp">
			<table class="table table-sm table-hover table-bordered">
				<thead class="bg-primary text-white">
					<tr>
						<th></th>
						<th>Name</th>
						<th>Party</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cand" items="${sessionScope.candidate.candidateList}">
						<tr>
							<td><input type="radio" name="cid" value="${cand.id}"></td>
							<td>${cand.name}</td>
							<td>${cand.pol_party}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-right">
				<button class="btn btn-danger" type="submit">Vote</button>
			</div>
			</form>
		</div>
	</div>
</body>
</html>