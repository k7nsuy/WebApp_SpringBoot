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
		<p class="h5 my-0 me-md-auto fw-normal">Admin</p>
			
			<a class="p-2 text-dark" href="${pageContext.request.contextPath}/member/join">멤버등록</a>
	<a class="p-2 text-dark" href="${pageContext.request.contextPath}/member/list">멤버list</a>
			

	</header>
</body>
</html>


	

	
