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
	rel="stylesheet" /> <!-- ${pageContext.request.contextPath} => ROOT (아무이름)
	server.servlet.context-path=/ROOT context-path값을 읽어온다  -->
<link rel="shortcut icon" type="image/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/800px-Apple_logo_black.svg.png">
<meta charset="UTF-8">
<title>Home</title>
<style>
	body {
		background-image: url("${pageContext.request.contextPath}/resources/images/Search_001.png");
		background-size: cover;
	}
</style>
</head>
<body>
	<header
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
		<p class="h5 my-0 me-md-auto fw-normal">HOME</p>
			
			<security:authorize access="!isAuthenticated()">
			<a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/customer/login">로그인</a> 
			<a class="p-2 text-dark" href="join">회원가입</a>
			</security:authorize>


			<security:authorize access="isAuthenticated()">
			
				<!-- security 에서 form이 if문 역할을 한다.  -->
				<form action="${pageContext.request.contextPath}/customer/logout" class="p-2 text-dark" 
				method="post">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}" />
					<input type="submit" class="btn btn-outline-success" value="로그아웃" />
				</form> 	
				권한 : <security:authentication property="authorities" /> <br />
				아이디 : <security:authentication property="name" /> 님 환영합니다. <br />
			<a class="p-2 text-dark" href="mypage">MYPAGE</a> 
			<a class="p-2 text-dark" href="board">게시판</a>
			</security:authorize>

			<a class="p-2 text-dark" href="shop">쇼핑몰</a> 
			<a class="p-2 text-dark" href="admin">관리자</a>

	</header>
</body>
</html>

