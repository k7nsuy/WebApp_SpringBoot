<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <title> JOIN </title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main-center.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
    </head>
    <body>
	        <div class="main-body">
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
						<div class="col-sm-6">
							<input type="submit" class="btn btn-outline-dark" value="회원가입" />
						</div>
	        	</div>
	        	</form>
	        </div>
    </body>
</html>
