<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
</head>

<body>
	<h3>

		<c:set var="firstName" value="Sachin" scope="session" />
		<c:set var="lastName" value="Tendulkar" />

		Full Name :
		<c:out value="<h5>${firstName} ${lastName}</h5>" escapeXml="true" />
		<br /> Hello , ${firstName} ${lastName} <br />

		<c:out value="Removing attributes" />
		<br />
		<c:remove var="firstName" />
		<c:remove var="lastName" />
		After removal <br /> Hello , ${firstName} ${lastName}
	</h3>
</body>
</html>