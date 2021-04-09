<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page session="true"%>
   <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<link type="text/css" media="screen" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link 
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" /> <!-- ${pageContext.request.contextPath} => ROOT (아무이름)
	server.servlet.context-path=/ROOT context-path값을 읽어온다  -->
<link rel="shortcut icon" type="image/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/800px-Apple_logo_black.svg.png">
<meta charset="UTF-8">
<title>Home</title>
<style>
</style>

</head>
<body>
	<header
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
		<p class="h5 my-0 me-md-auto fw-normal">Admin</p>
	</header>
	
	<div id="page">
					<div class="post">
			
	        <form action="${pageContext.request.contextPath}/member/join"
					method="post" enctype="multipart/form-data">
	        	<div class="center" style="margin-bottom: 5px">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	        	<h2 class="col-sm-8">유저등록</h2>
	        		<div class="col-sm-7">
		        		<label class="col-sm-3 col-form-label">아이디</label>
		        		<input class="form-control" name="userId" type="text" 
		        		required placeholder="아이디">
	        		</div>
	        		<div class="col-sm-7">
		        		<label class="col-sm-3 col-form-label">비밀번호</label>
		        		<input class="form-control" name="userPass" type="password" 
		        		required placeholder="비밀번호">
	        		</div>
	        		<div class="col-sm-7">
		        		<label class="col-sm-3 col-form-label">비밀번호 확인</label>
		        		<input class="form-control" name="userPass1" type="password" 
		        		required placeholder="비밀번호 재입력">
	        		</div>
	        		<div class="col-sm-7">
		        		<label class="col-sm-3 col-form-label">이름</label>
		        		<input class="form-control" name="userName" type="text" 
		        		required placeholder="이름">
	        		</div>
	        		<div class="col-sm-7">
		        		<label class="col-sm-3 col-form-label">주소</label>
		        		<input class="form-control" name="userAdress" type="text" 
		        		required placeholder="주소">
	        		</div>
	        		<div class="col-sm-7">
		        		<label class="col-sm-3 col-form-label">전화번호</label>
		        		<input class="form-control" name="userPhone" type="tel" placeholder="전화번호" 
		        		 pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required >
		        		 <small>Example : 010-4567-7890</small>
	        		</div>
	        		<div class="col-sm-7">
		        		<label class="col-sm-3 col-form-label">이메일</label>
		        		<input class="form-control" name="userEmail" type="email" required 
		        		placeholder="email">
	        		</div>
	        		<div class="col-sm-7">
		        		<label class="col-sm-3 col-form-label">이메일 확인</label>
		        		<input class="form-control" name="userEmail1" type="email" required 
		        		placeholder="email 재입력">
	        		</div>
	        		<br />
						<div class="col-sm-6">
							<input type="submit" class="btn btn-dark" value="회원가입" />
						</div>
	        	</div>
	        	</form>
	        	</div>
	        	</div>

</body>
</html>


	

	

	    
