<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
<style>
hr {
	border: 3px solid green;
}

h3 {
	margin: 30px 10px;
	font-weight: bolder;
}
h4 {
	color: blue;
	font-size: 20px;
	font-weight: 600px;
}
line {
	display: flex;
	justify-content: space-between;
}
</style>
</head>
<body>
	<div class="container">
	<div style="width:600px; padding:30px; border:1px solid #cccccc">
	<h3>상세보기</h3>
	<hr />
		글번호 : ${vo.no}<br />
		글제목 : ${vo.title}<br />
		작성자 : ${vo.writer}<br />
		조회수 : ${vo.hit}<br />
		내용 : ${vo.content}<br />
		등록일 : ${vo.regdate}<br />
		<hr />
			<h3>답글</h3>
			<hr />
			<c:forEach var="obj" items="${list}">
				<h4>답글번호 : ${obj.repno} </h4>
				답글내용 : ${obj.repcontent} <br />
				답글등록일 : ${obj.repregdate}
				<hr />
			</c:forEach> 
			<form action="${pageContext.request.contextPath}/noti/content" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<input type="hidden" name="no" value="${vo.no}" >
				<input type="submit" class="btn btn-outline-danger" value="답글삭제" >
			</form>
		<hr />
		<div class="line">
		<a href = "${pageContext.request.contextPath}/noti/list" class = "btn btn-primary">글목록</a>
		
		<a href = "${pageContext.request.contextPath}/noti/reply?no=${vo.no}" class = "btn btn-success">답글쓰기</a>

		<form action = "${pageContext.request.contextPath}/noti/delete" method="post" >
		<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
		<input type="hidden" name="no" value="${vo.no}" />
		<input type="submit" class = "btn btn-danger" value="삭제" />
		</form>
		</div>
	</div>
	</div>
</body>
</html>