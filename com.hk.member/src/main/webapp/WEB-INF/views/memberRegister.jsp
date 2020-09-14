<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='register' method='post'>
이름: <input type='text' name='mname'><br>
이메일: <input type='text' name='email'><br>
암호: <input type='password' name='pwd'><br>
<input type="submit" value="추가">
<input type="reset" value='취소'>
<input type="button" onclick='location.href="list"' value='리스트로'>

</form>
</body>
</html>