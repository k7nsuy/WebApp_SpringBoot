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
		<h4>물품목록</h4>
		<hr />
		<div>
			<a href="${pageContext.request.contextPath}/item/insert" class="btn btn-outline-success">물품등록</a>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>물품번호</th>
					<th>물품명</th>
					<th>물품가격</th>
					<th>물품수량</th>
					<th>등록날짜</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.getItmNo()}</td>
						<td><a href="${pageContext.request.contextPath}/item/content?no=${vo.getItmNo()}">${vo.getItmName()}</a></td>
						<td>${vo.price}</td>
						<td>${vo.quantity}</td>
						<td>${vo.itmdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>