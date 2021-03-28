<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <title> HOME </title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" />
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
	        <div class="main-center">
	        </div>
	        <div class="clicked-items">
	        	<div class="clicked-items_text">최근 본 상품</div>
	        </div>
        </div>
    </body>
</html>
