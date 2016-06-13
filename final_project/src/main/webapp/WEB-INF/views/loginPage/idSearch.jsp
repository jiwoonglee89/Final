<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>아이디 찾기</title>
</head>
<body>
<form>
<c:if test="${message==null}">
	<div id="find_id_result">
		<div class="size_long"><h1 class="title_find">아이디 찾기</h1></div>
	
			<div class="size_long"><h1 class="title_find">아이디는 ${id} 입니다</h1></div>

	</div>
</c:if>
<c:if test="${message!=null}">
	<script>
		alert("일치하는 아이디가 없습니다");
		history.go(-1);
	</script>
</c:if>
</form>
</body>
</html>