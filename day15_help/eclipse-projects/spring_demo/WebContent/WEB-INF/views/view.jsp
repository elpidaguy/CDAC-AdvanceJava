<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/complaint/view">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Complaint ID</td>
				<td><input type="text" name="compId" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="View Status" /></td>
			</tr>
		</table>

	</form>
</body>
</html>