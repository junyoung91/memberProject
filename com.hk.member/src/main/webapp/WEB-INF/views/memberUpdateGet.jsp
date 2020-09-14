<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./include/header.jsp" />
<h1>회원 등록</h1>
<form action='update' method='post'>
번호: <input type='text' name='mno' value='${member.mno}' readonly><br>
이름: <input type='text' name='mname' value='${member.mname}'><br>
이메일: <input type='text' name='email' value='${member.email}'><br>
암호: <input type='password' name='pwd' value='${member.pwd}'><br>
<input type='submit' value='수정'>
<input type='reset' value='취소'>
<input type='button' onclick="location.href='delete?mno=${member.mno}'" value='삭제'>
<input type='button' onclick="location.href='list'" value='리스트로'>
</form>
<jsp:include page="./include/footer.jsp" />
