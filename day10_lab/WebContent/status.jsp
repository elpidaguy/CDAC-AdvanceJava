<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank You</title>
</head>

<jsp:setProperty property="*" name="candidate"/>

<body>

<h3>Hello ${sessionScope.voter.email} ,</h3>
<br>
<c:if test="${sessionScope.voter.voterObj.status}">
	<h4>You have Already Voted!</h4>
</c:if>


<c:if test="${!sessionScope.voter.voterObj.status}">
	${sessionScope.candidate.incVotes()}
	${sessionScope.voter.UpdateStatus()}
	<h4>You have Voted Successfully!</h4>
</c:if>

<a href="index.jsp">Visit Again</a>

${pageContext.session.invalidate()}

</body>
</html>