<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<link 
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" /> <!-- ${pageContext.request.contextPath} => ROOT (아무이름)
	server.servlet.context-path=/ROOT context-path값을 읽어온다  -->
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
		<p class="h5 my-0 me-md-auto fw-normal">뭘 만들까?</p>
		<nav class="my-2 my-md-0 me-md-3">

			<a class="btn btn-outline-primary" href="login">로그인</a> <a
				class="p-2 text-dark" href="join">회원가입</a>
		
			<a class="p-2 text-dark" href="logout">로그아웃</a> <a
				class="p-2 text-dark" href="mypage">MYPAGE</a> <a
				class="p-2 text-dark" href="board">게시판</a>
			
			<a class="p-2 text-dark" href="shop">쇼핑몰</a> <a class="p-2 text-dark"
				href="admin">관리자</a>

		</nav>
	</header>
</body>
</html>