<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Num List ${requestScope.num_list}
User Name ${requestScope.nm}<br/>
User Age ${requestScope.user_age}<br/>
Join Date <fmt:formatDate value="${requestScope.join_date}" pattern="dd-MM-yyyy"/> 
<br/>
User Age via req params ${param.age}<br/>
Join Date via req params ${param.joinDate}<br/>
Customer details : ${requestScope.customer}
</body>
</html>