<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
	<div style="width:600px; padding:30px; border:1px solid #cccccc">
		글번호 : ${vo.brdno}<br />
		글제목 : ${vo.brdtitle}<br />
		글내용 : ${vo.brdcontent}<br />
		작성자 : ${vo.brdwriter}<br />
		조회수 : ${vo.brdhit}<br />
		날짜 : ${vo.brddate}<br />
		
		<a href = "${pageContext.request.contextPath}/board/list" class = "btn btn-primary">게시판목록</a>
		<c:if test="${prevNo ne 0}">
		<a href = "${pageContext.request.contextPath}/board/brdcontent?no=${prevNo}" class = "btn btn-success">이전글</a>
		</c:if>
		<c:if test="${nextNo ne 0}">
		<a href = "${pageContext.request.contextPath}/board/brdcontent?no=${nextNo}" class = "btn btn-success">다음글</a>
		</c:if>
		
		<form action = "${pageContext.request.contextPath}/board/delete" method="post" >
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}" />
		<input type="hidden" name="brdno" value="${vo.brdno}" />
		<input type="submit" class = "btn btn-danger" value="삭제" />
		</form>
		<a href = "${pageContext.request.contextPath}/board/update?brdno=${vo.brdno}" class = "btn btn-warning">수정</a>
	</div>
	</div>
</body>
</html>