<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>파일 업로드</h1>
<form action="/upload" method='post' enctype='multipart/form-data'>
	<input type='file' value='파일선택' name='file'>
	<input type="submit" value='업로드'>
</form>

</body>
</html>

