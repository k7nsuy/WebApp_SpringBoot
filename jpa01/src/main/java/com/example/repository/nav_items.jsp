<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <title> Item </title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main-center.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
    </head>
    <body>
        <div class="main-header">
        
        	<security:authorize access="!isAuthenticated()">
        	
            <span class="main-header_column"><a href="${pageContext.request.contextPath}/header/login">로그인</a></span>
            </security:authorize>
            
            <security:authorize access="isAuthenticated()">
            
			<%-- <security:authentication property="principal"/>  --%>
				Member : <security:authentication property="authorities"/> <br />
				'<security:authentication property="name"/>'님 환영합니다. <br />
				
				
				<form action="${pageContext.request.contextPath}/header/logout" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input class="main-header_column btn btn-outline-dark" type="submit" value="로그아웃" />
				</form>
			</security:authorize>
			<security:authorize access="!isAuthenticated()">
            <span class="main-header_column"><a href="${pageContext.request.contextPath}/header/join">회원가입</a></span>
            </security:authorize>
            <span class="main-header_column"><a href="${pageContext.request.contextPath}/header/orederlist">장바구니</a></span>
            
            <security:authorize access="isAuthenticated()">
            <c:if test="${Authority eq 'USER'}">
            <span class="main-header_column"><a href="${pageContext.request.contextPath}/header/mypage">마이페이지</a></span>
            </c:if>
            </security:authorize>
            <security:authorize access="isAuthenticated()">
            <c:if test="${Authority eq 'ADMIN'}">
            <span class="main-header_column"><a href="${pageContext.request.contextPath}/admin">관리자페이지</a></span>
            </c:if>
            </security:authorize>
        </div>
        <div class="main-nav">
        	<span><a href="${pageContext.request.contextPath}/home">MostBody</a></span>
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
	        
	        <main class="container">

		<div
			class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
			<h1 class="display-4">Pricing</h1>
			<p class="lead">ss</p>
		</div>

			<div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
			<c:forEach var="tmp" items="${list}">
		    	<div class="col">
			      <div class="card mb-4 shadow-sm">
				      <div class="card-header">
				        <h4 class="my-0 fw-normal">${tmp.code}</h4>
				      </div>
				      <div class="card-body">
					    <c:if test="${tmp.base64Img eq null}">
	    					<img src="images/default.jpg" width="100%" />
	    				</c:if>
	    			
	    				<c:if test="${tmp.base64Img ne null}">
	    					<img src="data:image/jpeg;base64,${tmp.base64Img}" width="100%"/>
	    				</c:if>
	    			
				        <h1 class="card-title pricing-card-title">${tmp.price} <small class="text-muted">/ 원</small></h1>
				        <ul class="list-unstyled mt-3 mb-4">
				          <li>${tmp.name}</li>
				          <li>남은수량 : ${tmp.quantity}</li>
				        </ul>
				        <button type="button" class="w-100 btn btn-lg btn-outline-primary">주문하기</button>
				      </div>
				    </div>
		    	</div>
		    </c:forEach>
		</div>

		<footer class="pt-4 my-md-5 pt-md-5 border-top">
			<div class="row">
				<div class="col-12 col-md">
					<img class="mb-2" src="/docs/5.0/assets/brand/bootstrap-logo.svg"
						alt="" width="24" height="19"> <small
						class="d-block mb-3 text-muted">&copy; 2017-2021</small>
				</div>
				<div class="col-6 col-md">
					<h5>Features</h5>
					<ul class="list-unstyled text-small">
						<li><a class="link-secondary" href="#">Cool stuff</a></li>
						<li><a class="link-secondary" href="#">Random feature</a></li>
						<li><a class="link-secondary" href="#">Team feature</a></li>
						<li><a class="link-secondary" href="#">Stuff for
								developers</a></li>
						<li><a class="link-secondary" href="#">Another one</a></li>
						<li><a class="link-secondary" href="#">Last time</a></li>
					</ul>
				</div>
				<div class="col-6 col-md">
					<h5>Resources</h5>
					<ul class="list-unstyled text-small">
						<li><a class="link-secondary" href="#">Resource</a></li>
						<li><a class="link-secondary" href="#">Resource name</a></li>
						<li><a class="link-secondary" href="#">Another resource</a></li>
						<li><a class="link-secondary" href="#">Final resource</a></li>
					</ul>
				</div>
				<div class="col-6 col-md">
					<h5>About</h5>
					<ul class="list-unstyled text-small">
						<li><a class="link-secondary" href="#">Team</a></li>
						<li><a class="link-secondary" href="#">Locations</a></li>
						<li><a class="link-secondary" href="#">Privacy</a></li>
						<li><a class="link-secondary" href="#">Terms</a></li>
					</ul>
				</div>
			</div>
		</footer>

	</main>
	        
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
