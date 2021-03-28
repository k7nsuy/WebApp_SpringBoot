<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <div class="main-header">
            <span class="main-header_column"><a href="${pageContext.request.contextPath}/header/login">로그인</a></span>
            <span class="main-header_column"><a href="${pageContext.request.contextPath}/header/join">회원가입</a></span>
            <span class="main-header_column"><a href="${pageContext.request.contextPath}/header/orederlist">장바구니</a></span>
            <span class="main-header_column"><a href="${pageContext.request.contextPath}/header/mypage">마이페이지</a></span>
        </div>
        <div class="main-nav">
        	<span><a href="${pageContext.request.contextPath}/home">logo</a></span>
            <span><a href="${pageContext.request.contextPath}/nav/items">상품보기</a></span>
            <span><a href="${pageContext.request.contextPath}/nav/best">베스트</a></span>
            <span><a href="${pageContext.request.contextPath}/nav/noti">공지사항</a></span>
            <span><a href="${pageContext.request.contextPath}/nav/review">상품후기</a></span>
            <span><a href="${pageContext.request.contextPath}/nav/question">문의하기</a></span>
        </div>
        <div class="main-body">
	        <div class="ad">
	            <img src="${pageContext.request.contextPath}/resources/images/ad2.gif">
	            <img src="${pageContext.request.contextPath}/resources/images/ad3.gif">
	            <img src="${pageContext.request.contextPath}/resources/images/ad4.gif">
	            <img src="${pageContext.request.contextPath}/resources/images/ad5.gif">
	        </div>
	        <div class="main-body">
	        	<div class="center">
	        	<h2 class="col-sm-8">로그인</h2>
	        		<div class="col-sm-7">
		        		<label class="col-sm-3 col-form-label">아이디</label>
		        		<input class="form-control" type="text" placeholder="아이디를 입력하세요.">
	        		</div>
	        		<div class="col-sm-7">
		        		<label class="col-sm-3 col-form-label">비밀번호</label>
		        		<input class="form-control" type="password" placeholder="비밀번호를 입력하세요.">
	        		</div>
						<div class="col-sm-6">
							<input type="submit" class="btn btn-outline-dark" value="로그인" />
						</div>
	        	</div>
	        </div>
	        <div class="main-body">
	        	<div class="clicked-items">
	        		<div class="clicked-items_text">
	        		최근 본 상품
	        		</div>
	        	</div>
	        </div>
        </div>
    </body>
</html>
