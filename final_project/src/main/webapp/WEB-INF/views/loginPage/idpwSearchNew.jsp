<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta charset="UTF-8">
<script src="<c:url value="resources/join.js" />"></script>
<title>아이디 비밀번호 찾기</title>
<script>
$(function(){
   open(url,"confirm","toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
   $("#submit_find_id").click(function(){
      if($("#name").val()=="") {
         alert("이름을 입력해 주세요.");
         $("#name").focus();
   } else {
   	
      if($("#phone").val()=="") {
         alert("핸드폰 번호를 입력해 주세요.");
         $("#phone").focus();
      }
   } else{
         $("#idSearch").submit();
      }
   });


   $("#submit_find_password").click(function(){
      if($("#id").val()=="") {
         alert("아이디를 입력해 주세요.");
         $("#id").focus();
   } else{
      if($("#phone").val()=="") {
         alert("핸드폰 번호를 입력해 주세요.");
         $("#phone").focus();
         }
   } else {
      if($("#birth").val()=="") {
         alert("생년원일을 입력해 주세요.");
         $("#birth").focus();
      }
   } else {
         $("#pwSearch").submit();
      }
   });

});
</script>
</head>
<body>

<c:if test="${message!=null}">
   <c:if test="${message=='errorPhone'}">
      <script>alert("일치하는 핸드폰 번호가 없습니다"); $("#phone").focus();</script>
   </c:if>
   <c:if test="${message=='incorrect'}">
      <script>alert("일치하는 정보가 없습니다"); $("#id").focus();</script>
   </c:if>
</c:if>
<div id="find">

	<form  name="idSearch" id="idSearch" action="idSearch.do">
	<table width="300" border="1" cellspacing="0" cellpadding="3" align="center">
	<tr>
		<td colspan="2" height="39" align="center" bgcolor="">
		<font size="+1"><b>아이디 찾기 </b></font><br><font color="black" align="right" size="-1"></font>
		</td>
	</tr>
	<tr>
				<td colspan="2" height="39" align="center" bgcolor="" width="300" width="300">
					<div id="find_id"></div>
					<div class="size_long" id="divname"><input type="text" class="text_login" id="name" name="name" maxlength="12" placeholder="이름"></div>
					<div class="size_long" id="divphone"><input type="text" class="text_login" id="phone" name="phone" maxlength="12" placeholder="핸드폰번호(01012345678)"></div>
					<input id="submit_find_id" class="btn_long" type="submit" name="confirm_id" value="아이디 확인">
				</td>
			</tr>
		</table>
	</form>
	<form action="pwSearch.do" name="pwSearch" id="pwSearch">
		<table width="300" border="1" cellspacing="0" cellpadding="3" align="center">
		<tr>
			<td colspan="2" height="39" align="center" bgcolor="">
			<font size="+1"><b>비밀번호 찾기</b></font><br><font color="black" align="right" size="-1"></font>
			</td>
		</tr>
		<tr>
			<td colspan="2" height="39" align="center" bgcolor="" width="300">
				<div id="find_password"></div>
				<div class="size_long" id="divid"><input type="text" class="text_login" id="id" name="id" maxlength="12" placeholder="아이디"></div>
				<div class="size_long" id="divphone"><input type="text" class="text_login" id="phone" name="phone" maxlength="12" placeholder="핸드폰 번호(01012345678)"></div>
				<div class="size_long" id="divbirth"><input type="text" class="text_login" id="birth" name="birth" maxlength="12" placeholder="생년월일"></div>
				<input id="submit_find_password" class="btn_long" type="submit" name="confirm_password" value="비밀번호 확인">
			
			</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>