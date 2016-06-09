<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우편번호 검색</title>
<script src="zipcheck.js"></script>
</head>
<body>
<center>
	<b>우편번호 찾기</b>
	<table>
		<form name="zipForm" method="post" action="zipCheck.do">
		<tr>
			<td>
				<br> 
				도로명 주소 입력 : <input name="area4"  type="text">
				<input type="button" value="검색" onclick="dongCheck();">
			</td>
		</tr>
		<input type="hidden" name="check" value="n">
		</form>
		<c:if test ="${check == 'n'}" >
			<c:if test="${ zipcode == null}">
			<tr>
				<td align="center"><br>검색된 결과가 없습니다.</td>
			</tr>
			</c:if>
			<<c:if test="${ zipcode != null}">
			<tr>
			<td align="center">
				<br> ※검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.
			</td>
		</tr>
		<tr>
			<td>
			
<c:forEach var="zip" items="${zipcode}">
<a href="javascript:sendAddress('${zip.zipcode }','${zip.area1}','${zip.area2}','${zip.area3}','${zip.area4}')">

${zip.zipcode }&nbsp;${zip.area1}&nbsp;${zip.area2}&nbsp;${zip.area3}&nbsp;${zip.area4}<br>
</a>

</c:forEach>
</td>
		</tr>
		</c:if>
</c:if>
		<tr>
			<td align="center"><br> <a href="javascript:this.close();">닫 기</a>
			</td>
		<tr>
			
	</table>
</center>
</body>
</html>