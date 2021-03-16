<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page session="true"%>
   <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<link 
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" /> 
<meta charset="UTF-8">
<title> HOME FOR ASSIGNMENT</title>
</head>
<body>
	<header
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
		<p class="h5 my-0 me-md-auto fw-normal">HOME</p>
		
			<security:authorize access="!isAuthenticated()">
			<a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/login">로그인</a> 
			<a class="btn btn-outline-success" href="join">회원가입</a>
			</security:authorize>


			<security:authorize access="isAuthenticated()">
			<form action="${pageContext.request.contextPath}/logout" class="p-2 text-dark" 
			method="post">
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}" />
				<input type="submit" class="btn btn-outline-success" value="로그아웃" />
			</form> 
			<a class="p-2 text-dark" href="board">회원정보변경</a>
			<a class="p-2 text-dark" href="shop">회원탈퇴</a> 
			권한 : <security:authentication property="authorities" /> <br />
			아이디 : <security:authentication property="name" /> 님 환영합니다. <br />
			</security:authorize>
			
	</header>
	
</body>
</html>