<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Cell Join Page</title>
</head>
<body>
<form name="joinForm" action="" method="post">
<table border="1">
<th>Web Cell 회원 가입 </th>
<tr colspan="2">회원정보 입력 <font color="red" >['*' 표시는 필수입력 사항입니다.]</font></tr>
<tr>
	<td> 아이디 </td>
	<td> <input type="text" name="id" maxlength="30" size="35"> </td>
	<td> <input type="button" value="중복 확인" onclick=""> </td>
</tr>  


</table>
</form>
</body>
</html>