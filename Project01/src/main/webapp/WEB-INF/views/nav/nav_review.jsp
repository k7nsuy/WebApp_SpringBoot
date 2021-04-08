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

			<form action="${pageContext.request.contextPath}/header/logout"
				method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<input class="main-header_column3 btn btn-outline-light"
					type="submit" value="Log out" />
			</form>
		</security:authorize>
		<security:authorize access="!isAuthenticated()">
			<span class="main-header_column"><a
				href="${pageContext.request.contextPath}/header/join">Join</a></span>
		</security:authorize>

		<security:authorize access="isAuthenticated()">
			<c:if test="${Authority eq 'USER'}">
			<span class="main-header_column"><a
					href="${pageContext.request.contextPath}/header/orderlist">Order List</a></span>
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
					
					<div style="padding:30px 0 0 0" class="container">
		<h2>Review</h2>
		<hr />
		<div class="search">
			<div>
				<a href="${pageContext.request.contextPath}/nav/reviewinsert" class="btn btn-outline-success">리뷰등록</a>
			</div>
		</div>

		<table class="table2" style="border:1px solid #cccccc">
			<thead>
				<tr>
					<th>리뷰번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>등록날짜</th>
					<th>리뷰사진</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="vo" items="${review}">
					<tr>
						<td>${vo.reviewNumber}</td>
						<td><a href="${pageContext.request.contextPath}/nav/reviewcontent?no=${vo.reviewNumber}">${vo.reviewTitle}</a></td>
						<td></td>
						<td>${vo.reviewHit}</td>
						<td>${vo.reviewDate}</td>
						<td>
						<c:if test="${vo.base64 ne null}">
                    		<img src="data:image/png;base64,${vo.base64}" width="20px" height="20px" />
                    	</c:if>
	                    	
                    	<c:if test="${vo.base64 eq null}">
                    		NO이미지
                    	</c:if>
                    	</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		
		 <div class="page" id="pagination-div"></div>

	<!-- jquery cdn -->		
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<!-- twbspagination cdn -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js"></script>
	
	<script>
		$(function(){
			    $('#pagination-div').twbsPagination({
				    totalPages: Number('${totPages}'),
		            visiblePages: 10,
		            startPage : Number('${param.page}'),
		            initiateStartPageClick :false,
		            onPageClick: function (event, page) {
		            window.location.href = "${pageContext.request.contextPath}/nav/review?txt="+'${param.txt}'+ "&page="+page;
		            }
			    });
			});	
	</script>
					
					</div>
					<!-- post -->
				</div>
					<!-- content -->
			</div>
			<!-- page -->				
				
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

</body>
</html>




