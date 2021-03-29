<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" />
	
<title> HOME </title>
<style>
.home-top {
	display: flex;
	justify-content: space-between;
	padding: 15px;
}

.home-top__text {
	font-size:25px;
}
</style>
</head>
<body>
	<h3>메인화면</h3>
	<security:authorize access="!isAuthenticated()">
	<a href="${pageContext.request.contextPath}/login">로그인</a>
	</security:authorize>
	
	<security:authorize access="isAuthenticated()">
		<security:authentication property="principal"/> <hr /> 
		ROLE : <security:authentication property="authorities"/> <br />
		USERID : <security:authentication property="name"/> 님 환영합니다 <br />
		
		<form action="${pageContext.request.contextPath}/logout" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" value="로그아웃" />
		</form>
	</security:authorize>
</body>
</html>