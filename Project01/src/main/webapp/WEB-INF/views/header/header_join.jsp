<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>HOME</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main-center.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link type="text/css" media="screen" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link href='http://fonts.googleapis.com/css?family=Ubuntu+Condensed'
	rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Marvel'
	rel='stylesheet' type='text/css' />
<link
	href='http://fonts.googleapis.com/css?family=Marvel|Delius+Unicase'
	rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Arvo'
	rel='stylesheet' type='text/css' />

</head>
<body>
	<div class="main-header">

		<security:authorize access="!isAuthenticated()">

			<span class="main-header_column"><a
				href="${pageContext.request.contextPath}/header/login">Login</a></span>
		</security:authorize>

		<security:authorize access="isAuthenticated()">
			<span class="main-header_column2"> <%-- <security:authentication property="principal"/>  --%>
				Member <security:authentication property="authorities" /> <br />
				Welcome <security:authentication property="name" /> ! <br />
			</span>

			<form action="${pageContext.request.contextPath}/header/logout" method="post">
				<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
				<input class="main-header_column3 btn btn-outline-light" type="submit" value="Log out" />
			</form>
		</security:authorize>
		<security:authorize access="!isAuthenticated()">
			<span class="main-header_column"><a
				href="${pageContext.request.contextPath}/header/join">Join</a></span>
		</security:authorize>

		<security:authorize access="isAuthenticated()">
			<c:if test="${Authority eq 'USER'}">
				<span class="main-header_column"><a
					href="${pageContext.request.contextPath}/header/orderlist">Order
						List</a></span>
				<span class="main-header_column"><a
					href="${pageContext.request.contextPath}/header/mypage">My Page</a></span>
			</c:if>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			<c:if test="${Authority eq 'ADMIN'}">
				<span class="main-header_column"><a
					href="${pageContext.request.contextPath}/admin">Admin Page</a></span>
			</c:if>
		</security:authorize>
	</div>

	<div id="wrapper">
		<div id="wrapper2">
			<div id="header" class="container">
				<div id="logo">
					<h1>
						<a href="${pageContext.request.contextPath}/home">Most <span>Body</span></a>
					</h1>
				</div>
				<div id="menu">
					<ul>
						<li class="current_page_item"><a
							href="${pageContext.request.contextPath}/nav/items">Item</a></li>
						<li><a href="${pageContext.request.contextPath}/nav/best">Best</a></li>
						<li><a href="${pageContext.request.contextPath}/nav/noti">Anouncement</a></li>
						<li><a href="${pageContext.request.contextPath}/nav/review">Review</a></li>
						<li><a href="${pageContext.request.contextPath}/nav/question">Question</a></li>
					</ul>
				</div>
			</div>
			<div id="banner"></div>

			<!-- end #header -->
			<div id="page">
				<div id="content">
					<div class="post">

						<form action="${pageContext.request.contextPath}/header/join"
							method="post" >
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<h2 class="col-sm-8">JOIN</h2>
							<div class="col-sm-7">
								<label class="col-sm-3 col-form-label">아이디</label> 
								<input class="form-control" name="userId" type="text" required
									placeholder="아이디" />
							</div>
							<div class="col-sm-7">
								<label class="col-sm-3 col-form-label">비밀번호</label> <input
									class="form-control" id="pwd1" name="userPass" type="password" required
									placeholder="비밀번호">
							</div>
							<div class="col-sm-7">
								<label class="col-sm-3 col-form-label">비밀번호 확인</label> <input
									class="form-control" id="pwd2" name="userPass1" type="password" required
									placeholder="비밀번호 재입력">
							</div>
							<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다</div>
							<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다</div>
							<div class="col-sm-7">
								<label class="col-sm-3 col-form-label">이름</label> <input
									class="form-control" name="userName" type="text" required
									placeholder="이름">
							</div>
							<div class="col-sm-7">
								<label class="col-sm-3 col-form-label">주소</label> <input
									class="form-control" name="userAdress" type="text" required
									placeholder="주소">
							</div>
							<div class="col-sm-7">
								<label class="col-sm-3 col-form-label">전화번호</label> <input
									class="form-control" name="userPhone" type="tel"
									placeholder="010-0000-0000" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
									required>
							</div>
							<div class="col-sm-7">
								<label class="col-sm-3 col-form-label">이메일</label> <input
									class="form-control" id="email1" name="userEmail" type="email" required
									placeholder="email" >
							</div>
							
							<div class="col-sm-7">
								<label class="col-sm-3 col-form-label">이메일확인</label> <input
									class="form-control" id="email2" name="userEmail2" type="email" required
									placeholder="email확인" >
							</div>
							<div class="alert alert-success" id="alert-success2">이메일이 일치합니다</div>
							<div class="alert alert-danger" id="alert-danger2">이메일이 일치하지 않습니다</div>
							<br />
							<div class="col-sm-6">
								<input type="submit" id="submit" class="btn btn-outline-dark" value="회원가입" />
							</div>
						</form>
						<br />
					</div>
				</div>
				
				<div style="clear: both;">&nbsp;</div>
				
			</div>
			<!-- end #content -->
			<!-- <div id="sidebar">
					<ul>
						<li>
							<div id="search">
								<form method="get" action="#">
									<div>
										<input type="text" name="s" id="search-text" value="" /> <input
											type="submit" id="search-submit" value="GO" />
									</div>
								</form>
							</div>
							<div style="clear: both;">&nbsp;</div>
						</li>
						<li>
							<h2>마이 페이지</h2>
							<ul>
								<li><a href="#">Aliquam libero</a></li>
								<li><a href="#">Consectetuer adipiscing elit</a></li>
								<li><a href="#">Metus aliquam pellentesque</a></li>
								<li><a href="#">Suspendisse iaculis mauris</a></li>
								<li><a href="#">Metus aliquam pellentesque</a></li>
								<li><a href="#">Suspendisse iaculis mauris</a></li>
								<li><a href="#">Urnanet non molestie semper</a></li>
								<li><a href="#">Proin gravida orci porttitor</a></li>
							</ul>
						</li>
					</ul>
				</div> -->
			<!-- end #sidebar -->
			<div style="clear: both;">&nbsp;</div>
			<!-- end #page -->
			<div id="footer">
				<p>
					&copy; MostBody. All rights reserved. Design by <a
						href="${pageContext.request.contextPath}/home" rel="nofollow">MostBody</a>.
				</p>
			</div>
		</div>
	</div>
	
	

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#alert-success").hide();
        $("#alert-danger").hide();
        $("input").keyup(function(){
            var pwd1=$("#pwd1").val();
            var pwd2=$("#pwd2").val();
            if(pwd1 != "" || pwd2 != ""){
                if(pwd1 == pwd2){
                    $("#alert-success").show();
                    $("#alert-danger").hide();
                    $("#submit").removeAttr("disabled");
                }else{
                    $("#alert-success").hide();
                    $("#alert-danger").show();
                    $("#submit").attr("disabled", "disabled");
                }    
            }
        });
    });
</script>
<script type="text/javascript">
    $(function(){
        $("#alert-success2").hide();
        $("#alert-danger2").hide();
        $("input").keyup(function(){
            var email1=$("#email1").val();
            var email2=$("#email2").val();
            if(email1 != "" || email2 != ""){
                if(email1 == email2){
                    $("#alert-success2").show();
                    $("#alert-danger2").hide();
                    $("#submit").removeAttr("disabled");
                }else{
                    $("#alert-success2").hide();
                    $("#alert-danger2").show();
                    $("#submit").attr("disabled", "disabled");
                }    
            }
        });
    });
</script>
​

</body>
</html>


