<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload form</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		Choose File to Upload : <input type="file" name="contents" />
		 <input type="submit" value="Upload File" />
	</form>
</body>
</html>