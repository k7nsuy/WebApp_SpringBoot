<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- html에서 자바문법을 간편하게 쓰게해준다 -->
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
<!-- css스타일시트 쓰기 위함 -->
<meta charset="UTF-8">
<style type="text/css">
	.page {
	display: flex;
	justify-content: center;
	}
	
	.search {
	display: flex;
	justify-content: space-between;
	margin: 17px 17px;
	}
	
	.search-text {
	margin-right: 5px;
	height: 40px;
	width: 200px;
	border:2px solid;
	border-radius: 5px;
	}
	
	.insert {
	padding-bottom: 15px;
	}
</style>
</head>
<body>
	<div class="search">
	<form action="${pageContext.request.contextPath}/item/list" method="get" class="search">
		<input type="text" class="search-text" name="txt" placeholder="검색" />
		<input type="submit" class="btn btn-outline-dark" value="검색" />
	</form>
	</div>

	<div style="padding:30px 0 0 0" class="container">
		<h4>장바구니</h4>
		<hr />

		<table class="table" style="border:1px solid #cccccc">
			<thead>
				<tr>
					<th>물품번호</th>
					<th>물품명</th>
					<th>물품가격</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="vo" items="${olist}">
					<tr>
						<td>${vo.itemNumber}</td>
						<td>${vo.itemName}</td>
						<td>${vo.itemPrice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		
	<!-- jquery cdn -->		
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	
</body>
</html>