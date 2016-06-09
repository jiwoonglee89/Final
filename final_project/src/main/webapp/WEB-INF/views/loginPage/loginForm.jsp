<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
$(function(){
	$("#btn_login_submit").click(function(){
		check();
	});
	$("#btn_join").click(function(){
		$(location).attr("href","/final_project/register/inputForm.do");
	});
	$("#btn_find").click(function(){
		$(location).attr("href","/final_project/register/idSearch.do");
	});
    $("#password").keyup(function(e){
        if(e.keyCode == 13){
        	check();
        }
    });
    
});
function check() {
	if($("#id").val()=="") {
		alert("아이디를 입력해 주세요");
		$("#id").focus();
		return false;
	}
	if($("#password").val()=="") {
		alert("비밀번호를 입력해 주세요");
		$("#password").focus();
		return false;
	} 
	$("#loginForm").submit();
}
</script>
<title>로그인</title>
</head>
<body>
<c:if test="${login_status!=2}">
	<%response.sendRedirect("/final_project/main/mainForm.do"); %>
</c:if>
<c:if test="${message!=null}">
	<script>alert("아이디 또는 패스워드가 일치하지 않습니다");</script>
</c:if>
<div id="logon">
	<form method="post" action="" name="loginFrom" id="loginForm">
		<div id="loginForm">
		
			<div id="div_id" class="size_long"><input type="text" class="text_login" id="id" name="id" placeholder="아이디" ></div>
			<div id="div_password" class="size_long"><input type="password" class="text_login" id="password" name="password" placeholder="비밀번호"></div>	
			<div id="btn_login_submit" class="btn_long"><a href="" >로 그 인</a></div>
		</div>
	</form>
	<div id="join_find">
		<div id="btn_join" class="btn_long"><a href="join.do" >회 원 가 입</a></div>
		<div id="btn_find" class="btn_long"><a href="" >아이디/비밀번호 찾기</a></div>
	</div>
</div>
</body>
</html>