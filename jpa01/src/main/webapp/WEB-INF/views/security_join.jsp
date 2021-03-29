<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>security_join.jsp</title>
</head>

<body>
	회원가입 <br />
	<form action="${pageContext.request.contextPath}/join" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		아이디 : <input type="text" name="cstid" /><br />
		암호 : <input type="password" name="cstpw" /><br />
		암호확인 : <input type="password" name="cstpw1" /><br />
		이름 : <input type="text" name="cstname" /><br />
		연락처 : <input type="text" name="cstphone" /><br />
		권한 : 
		<select name="cstrole">
			<option value="ADMIN">ADMIN</option>
			<option value="VVIP">VVIP</option>
			<option value="VIP">VIP</option>
			<option value="FAMILY">FAMILY</option>
		</select><br />
		<input type="submit" value="회원가입" /><br />	
	</form>
</body>
</html>