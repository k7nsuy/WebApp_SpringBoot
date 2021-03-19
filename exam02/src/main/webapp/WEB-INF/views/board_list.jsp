<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- html에서 자바문법을 간편하게 쓰게해준다 -->
<!DOCTYPE html>
<html>
<head>
<link href="./CSS/bootstrap.min.css" rel="stylesheet" />
<!-- css스타일시트 쓰기 위함 -->
<meta charset="UTF-8">
</head>
<body>
	<div style="padding:30px 0 0 0" class="container">
		<h4>게시판목록</h4>
		<hr />
		<div>
			<a href="${pageContext.request.contextPath}/board/insert" class="btn btn-outline-success">글쓰기</a>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>날짜</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="vo" items="${brdlist}">
					<tr>
						<td>${vo.brdno}</td>
						<td><a href="${pageContext.request.contextPath}/board/content?brdno=${vo.brdno}">${vo.brdtitle }</a></td>
						<td>${vo.brdwriter}</td>
						<td>${vo.brdhit}</td>
						<td>${vo.brddate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>