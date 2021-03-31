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
		물품번호 : ${vo.itemNumber}<br />
		물품명 : ${vo.itemName}<br />
		물품가격 : ${vo.itemPrice}<br />
		물품수량 : ${vo.itemQuantity}<br />
		물품영양 : ${vo.itemNutrition}<br />
		물품상세 : ${vo.itemDetail}<br />
		물품추천 : ${vo.itemRecommend}<br />
		물품HIT : ${vo.itemHit}
		
		<a href = "${pageContext.request.contextPath}/item/list" class = "btn btn-primary">아이템목록</a>
		<c:if test="${prevNo ne 0}">
		<a href = "${pageContext.request.contextPath}/item/content?no=${prevNo}" class = "btn btn-success">이전글</a>
		</c:if>
		<c:if test="${nextNo ne 0}">
		<a href = "${pageContext.request.contextPath}/item/content?no=${nextNo}" class = "btn btn-success">다음글</a>
		</c:if>
		
		<form action = "${pageContext.request.contextPath}/item/delete" method="post" >
		<input type="hidden" name="no" value="${vo.no}" />
		<input type="submit" class = "btn btn-danger" value="삭제" />
		</form>
		<a href = "${pageContext.request.contextPath}/item/update?no=${vo.no}" class = "btn btn-warning">수정</a>
	</div>
	</div>
</body>
</html>