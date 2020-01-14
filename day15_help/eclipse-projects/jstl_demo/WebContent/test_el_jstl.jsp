<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isThreadSafe="false"
	trimDirectiveWhitespaces="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form>
		Choose Number <select name="num" multiple="multiple">
			<option value="200">200
			<option value="300">300
			<option value="400">400
			<option value="500">500
			<option value="600">600
		</select> <input type="submit" name="btn" value="Test">
	</form>
	<c:if test="${param.btn eq 'Test'   }">
		<h3>Listing Req Param Values</h3>
		${paramValues.num[0]} <br />
		${paramValues.num[1]} <br />
			${paramValues.num[2]} <br />
List all Cookies : <br />
		<c:forEach var="c" items="${cookie}">
			<%--${cookie} set of entries.Set<Map.Entry>
			c : Map.Entry , API getKey() n getValue()
			 map key : 	cookie name 
			 value : cookie class instance 
			 --%>
Cookie Name ${c.key} ${c.value.value}<br />
		</c:forEach>
		<br />
List All Request Headers : <br />
		<c:forEach var="c" items="${header}">
			<%--${header} entry map  --%>
Header Name : ${c.key} Value : ${c.value}<br />
		</c:forEach>


	</c:if>
</body>
</html>