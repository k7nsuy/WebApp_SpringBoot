<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Insert</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/item/insert" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		물품명 : <input type="text" name="itemName" > <br />
		물품가격 : <input type="text" name="itemPrice" > <br />
		물품수량 : <input type="text" name="itemQuantity" > <br />
		물품영양정보 : <input type="text" name="itemNutrition" > <br />
		물품상세 : <input type="text" name="itemDetail" > <br />
		물품추천 : <input type="checkbox" name="itemRecommend" value="infancy" >유아기 
		<input type="checkbox" name="itemRecommend" value="adolescence" >청소년기 
		<input type="checkbox" name="itemRecommend" value="adultWomen" >성인여자 <br />
		<input type="checkbox" name="itemRecommend" value="adultMen" >성인남자 
		<input type="checkbox" name="itemRecommend" value="middleWomen" >중년여자 
		<input type="checkbox" name="itemRecommend" value="middleMen" >중년남자 <br />
		<input type="checkbox" name="itemRecommend" value="oldWomen" >고령여자 
		<input type="checkbox" name="itemRecommend" value="oldMen" >고령남자 <br /> -->
		<input type="submit" value="물품등록" >
	</form>
</body>
</html>