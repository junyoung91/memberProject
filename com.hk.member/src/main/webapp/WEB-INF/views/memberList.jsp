<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<%@include file="include/header.jsp" %>

<%-- <c:forEach var="member" items="${members}">
	${member.mno } , ${member.email } , ${member.pwd } , ${member.mname } , ${member.cre_date } , ${member.mod_date } <br>
</c:forEach> --%>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">MEMBER</h1>
          <p class="mb-4">사용자 리스트
          &nbsp;&nbsp;&nbsp;<a href="register">등록</a>
          &nbsp;&nbsp;&nbsp; 로그인 사용자 정보 :  <c:out value="${loginMember.mname }" />
          &nbsp;&nbsp;&nbsp;<a href="../auth/logout">로그아웃</a>
          </p>
<!--           이미 되있는데? ㅋㅋㅋ  이게 지금 이미 우리가 로그인을 안하면 리스트 페이지로 안가게끔 만들어놔서 그냥 이렇게 해놨네 -->
<%--           로그인이 되야만 리스트로 가지니까 당연히 ${loginMember.mname }이값이 존재한다는 가정하에 만들어놨네 if문 없이 그냥 바로 이름하고 로그아웃이라고 표시되게 --%>
<!--           오늘 거의.. 복붙한거라.. 자세히 정확히는 모르겟어요 =-=;; -->
<%--           음 원래는 리스트를 보는거는 예외처리해서 리스트까지는 그냥 로그인 없이 볼수 있게 만들고 거기서 ${loginMember.mname }이 정보가 있는지 없는지 판별해서 --%>
<%--           저 정보가 없으면 로그인 하라는 글자만 딱 띄워놓고 ${loginMember.mname } 이 값이 존재하면 로그인은 안나오고 이 사람 이름 로그아웃 이라고 나오게 표시하는걸로 나는 만들었는데 --%>
<%--           여기는 로그인안하면 리스트 자체를 못가게 해놔서 리스트가 열렸다는건 당연히 ${loginMember.mname } 이 값이 존재한다는 소리고 그래서 로그인 부분은 없고 사람이름+ 로그아웃 만 그냥 구현해놨네 --%>
<%-- 	단순한거죠 구현된게 여기서 <c:out value= 이거뜻하는게 그냥 문법인가요? c:out은 그냥 출력하는거로 알고있는데 sysout처럼? 근데 여긴 html이니까 사실 그냥 출력되는건데 굳이 하는 이유는 모르겠네 --%>
<%-- 	 로그인 사용자 정보 :  <c:out value="${loginMember.mname }" /> --%>
<%-- 	 로그인 사용자 정보 : ${loginMember.mname } 이렇게만 쓰면 에러나지 않아요? 벨뷰값못찾아서 아하 이거 그거네<c:out value="${loginMember.mname }" 이렇게 쓰면 안에 ${loginMember.mname } --%>
<%-- 	 이게 값이 존재하면 표시해주고 존재 하지않으면 아무것도 표시안해줘 그래서 에러 안남 반대로 생각했어요 저값이 없으면 안으로 못들어가서 그냥 에러나는거고 같은 이메일을 치면 포문안쪽으로 들어가서  --%>
<%-- 	 실행되는  굳//끗? 넵 감사합니당!!! 오케바리! --%>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">

            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>#번호</th>
                      <th>이름</th>
                      <th>패스워드</th>
                      <th>이메일</th>
                      <th>작성일</th>
                      <th>수정일</th>
                      <th>삭제</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${members}" var="member">
                    <tr>
                      <td><a href='update?mno=<c:out value="${member.mno }" />' ><c:out value="${member.mno }" /></a></td>
                      <td><c:out value="${member.mname }" /></td>
                      <td><c:out value="${member.pwd }" /></td>
                      <td><c:out value="${member.email }" /></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${member.cre_date }" /></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${member.mod_date }" /></td>
                       <td><a href='delete?mno=<c:out value="${member.mno }" />' ><input type='submit' value='삭제'></a></td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2020</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->


<%@include file="include/footer.jsp" %>