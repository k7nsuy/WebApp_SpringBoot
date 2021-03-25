<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
	<div style="width:600px; padding:30px; border:1px solid #cccccc">
	<h4>상세보기</h4>
		글번호 : ${vo.no}<br />
		글제목 : ${vo.title}<br />
		작성자 : ${vo.writer}<br />
		조회수 : ${vo.hit}<br />
		내용 : ${vo.content}<br />
		등록일 : ${vo.regdate}<br />
		<hr />
			<c:forEach var="obj" items="${list}">
				${obj.repcontent}
			</c:forEach> 
		<hr />
		
		<a href = "${pageContext.request.contextPath}/board/list" class = "btn btn-primary">글목록</a>
		
		<a href = "${pageContext.request.contextPath}/board/reply?no=${vo.no}" class = "btn btn-success">답글쓰기</a>

		<form action = "${pageContext.request.contextPath}/board/delete" method="post" >
		<input type="hidden" name="no" value="${vo.no}" />
		<input type="submit" class = "btn btn-danger" value="삭제" />
		</form>
	</div>
	</div>
</body>
</html>