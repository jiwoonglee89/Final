<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>

<c:if test="${id == null}">
	<form method="post" action="" name="loginFrom">
	<center>
	<table width="260" cellpadding="0" cellspacing="0" align="center" border="1">
	<th colspan="2">로그인</th>
	<tr>
	<td>아이디</td>
	<td><input type="text" class="text_login" id="id" name="id" placeholder="아이디" required placeholder="ID 입력"></td>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" class="text_login" id="passwd" name="passwd" placeholder="비밀번호" required placeholder="Password 입력"></td>
	</tr>
	<tr>
		<td><input type="submit" value="로그인"></td>
		<td><input type="button" value="회 원 가 입" onclick="javascript:window.location='join.do'"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="button" value="아이디/비밀번호 찾기" onclick="javascript:window.location='idpwSearchNew.do'"></td>
	</tr>
	</table>
	</center>
	</form>
</c:if>

<c:if test="${id != null }">
				<table width="260" cellpadding="0" cellspacing="0" align="center" border="1">
						<tr>
							<td rowspan="3" align="center">${id}님이<br> 방문하셨습니다
								<form method="post" action="">
									<input type="submit" value="로그아웃">
								</form>
								<form method="post" action="">
									<input type="submit" value="나의 정보">
								</form>
							</td>
						</tr>
					</table>
				</td>
</c:if>
</body>
</html>