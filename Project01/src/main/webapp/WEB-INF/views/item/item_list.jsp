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
		<h4>물품목록</h4>
		<hr />
		<div class="insert">
			<a href="${pageContext.request.contextPath}/item/insert" class="btn btn-outline-success">물품등록</a>
		</div>

		<table class="table" style="border:1px solid #cccccc">
			<thead>
				<tr>
					<th>물품번호</th>
					<th>물품명</th>
					<th>물품가격</th>
					<th>물품수량</th>
					<th>물품영양</th>
					<th>물품상세</th>
					<th>물품추천</th>
					<th>물품HIT</th>
					<th>이미지</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.itemNumber}</td>
						<td><a href="${pageContext.request.contextPath}/item/content?no=${vo.itemNumber}">${vo.itemName}</a></td>
						<td>${vo.itemPrice}</td>
						<td>${vo.itemQuantity}</td>
						<td>${vo.itemNutrition}</td>
						<td>...</td>
						<td>${vo.itemRecommend}</td>
						<td>${vo.itemHit}</td>
						<td>
						<c:if test="${vo.base64 ne null}">
                    		<img src="data:image/png;base64,${vo.base64}" width="50px" height="50px" />
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
		            window.location.href = "${pageContext.request.contextPath}/item/list?txt="+'${param.txt}'+ "&page="+page;
		            }
			    });
			});	
	</script>
		
</body>
</html>