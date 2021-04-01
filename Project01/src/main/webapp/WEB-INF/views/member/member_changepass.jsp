<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/member/changepass" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	비밀번호 변경 : <input type="text" value="" name="userPass" >
	<input type="submit" value="비밀번호변경" />
	</form>
</body>
</html>