<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ID 입력값 : <input type="text" name="txt"  onchange="myFunction(this.value)">

<script>
function myFunction(val) {
  alert("The input value has changed. The new value is: " + val);
}
</script>
</body>
</html>

