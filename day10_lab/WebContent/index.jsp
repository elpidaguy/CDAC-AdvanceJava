<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Login Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


</head>

<jsp:useBean id="voter" class="beans.VoterBean" scope="session" />
<jsp:useBean id="candidate" class="beans.CandidateBean" scope="session" />

<body class="container mt-5">
	<div class="card" style="margin-left:30%;width:50%">
		<div class="card-head p-2">
			<h4 align="center">Voter Login</h4>
		</div>

		<div class="card-body">

			<div class="text-center">
				<form method="post" action="validate.jsp">
					<table class="table table-sm">
						<tr>
							<td>User Email :</td>
							<td><input placeholder="Enter email" class="form-control"
								type="text" name="email" /></td>
						</tr>
						<tr>
							<td>Password :</td>
							<td><input placeholder="Enter Password" class="form-control"
								type="password" name="password" /></td>
						</tr>
						
						<tr>
							<td><button type="submit" class="btn btn-danger"
									formaction="register.jsp">Register</button></td>
							<td><button type="submit" class="btn btn-primary">Login</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	
	<div>
	<h4 style="color: red !important">${sessionScope.voter.message}</h4>
	</div>
</body>
</html>