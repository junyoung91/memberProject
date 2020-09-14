<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="./include/header.jsp" />
<h1>회원 등록</h1>
<form action='delete' method='post'>
  ${mno } 을 진짜 지우시겠습니까?
  <input type="hidden" name="mno" value="${mno}">
  
<input type='submit' value='삭제'>
<input type='reset' value='취소'>
<input type='button' onclick="location.href='list'" value='리스트로'>
</form>
<jsp:include page="./include/footer.jsp" />
