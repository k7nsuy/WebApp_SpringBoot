<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="home-top">
	<div class="home-top__text">게시판</div>
	<div class="home-top__menu">
	<a href="${pageContext.request.contextPath}/board/insert" class="btn btn-success">게시판등록</a>
	</div>
	</div>
</body>
</html>