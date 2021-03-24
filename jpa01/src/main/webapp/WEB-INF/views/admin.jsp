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
	<div class="home-top__text">This is Home!</div>
	<div class="home-top__menu">
	<a href="${pageContext.request.contextPath}/user/join" class="btn btn-success">유저등록</a>
	<a href="${pageContext.request.contextPath}/user/list" class="btn btn-success">유저리스트</a>
	<a href="${pageContext.request.contextPath}/team/insert" class="btn btn-primary">팀등록</a>
	<a href="${pageContext.request.contextPath}/team/list" class="btn btn-primary">팀리스트</a>
	</div>
	</div>
</body>
</html>