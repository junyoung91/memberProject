<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체크하기</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"> 
</script>
<script type="text/javascript">
$().ready(function(){
	$("#email").change(function(){
		$("#result").val("");
		var emailValue=$("#email").val();

		$.ajax({
			url : '/member/rest/checkIdDup',
			data : {
				email : emailValue

				},

				dataType : 'text', method : 'get', success: function(data) {
					if (data=="0") {
						 $("#result").val("사용 가능합니다.");

						}else{
							$("#result").val("중복 입니다. 다시 입력해주세요");
				            $("#email").focus();
							}
					},
					error:function(){
						$("#result").val("중복 되었습니다");
					}
		});
	});
});
</script>

</head>
<body>

	ID를 입력하세요
	<input type="text" name="email" id="email">
	<br>
	<input type="text" id="result" value="" size="50">
	<p>데이터 현황</p>
	<div>
		<table id="memberList" border="1">
		</table>
	</div>

	<script>
$().ready(function() {
      $.ajax({
         url : '/member/rest/listJson',
         dataType : 'json',
         method : 'get',
         success : function(data) {
            $.each( data, function( key, value ) {
                 var tdValue = "";
                  $.each(value, function(k1, v1) {
                  	tdValue += v1 + ",";
                  });
                 
                  $('#memberList').append("<tr><td>" + tdValue + "</td></tr>");
			})
		}
	});
});
</script>
</body>
</html>