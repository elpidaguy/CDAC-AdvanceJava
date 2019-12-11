<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<style type="text/css">
.button:hover {
	background-color: red !important;
	color: wheat;
}

.button {
	text-align: right;
	padding: 5px;
	color: black;
	background-color: #e6e6fa;
}

.table {
	padding: 5px;
}
</style>
</head>

<jsp:useBean id="voter" class="beans.VoterBean" scope="session" />
<jsp:useBean id="candidate" class="beans.CandidateBean" scope="session" />

<body>
	<div>
		<form method="post" action="validate.jsp">
			<table class="table"
				style="border: 1;background-color: #E91E63 !important; margin: auto;">
				<tr>
					<td>Enter User Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Enter Password</td>
					<td><input type="password" name="password" /></td>
				</tr>

				<tr>
					<td><button type="submit" class="button">Login</button></td>
					<td><button type="submit" class="button" formaction="adminLogin.jsp">Admin Login</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>