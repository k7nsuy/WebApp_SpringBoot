<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css?ver=1"
	rel="stylesheet" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<div style="margin-top: 30px">
			<h3>물품정보수정</h3>
			<hr>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<form action="${pageContext.request.contextPath}/item/update"
					method="post" enctype="multipart/form-data">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

					<div class="row" style="margin-bottom: 5px">
					
						<label for="labelId" class="col-sm-3 col-form-label">물품번호</label>
						<div class="col-sm-9">
							<input type="text"  name="itemNumber"
								value="${vo2.itemNumber}" readonly /><br />
						</div>
					
						<label for="labelId" class="col-sm-3 col-form-label">물품명</label>
						<div class="col-sm-9">
							<input type="text"  name="itemName"
								value="${vo2.itemName}" /><br />
						</div>

						<label for="labelname" class="col-sm-3 col-form-label">물품가격</label>
						<div class="col-sm-9">
							<input type="text"  name="itemPrice"
								value="${vo2.itemPrice}" autofocus /><br />
						</div>

						<label for="labelphone" class="col-sm-3 col-form-label">물품수량</label>
						<div class="col-sm-9">
							<input type="text"  name="itemQuantity"
								value="${vo2.itemQuantity}" autofocus /><br />
						</div>
						
					</div>
						<label for="labelphone" >물품추천</label> <br />
							물품추천 : <input type="checkbox" name="itemRecommend" value="infancy" >유아기 
						<input type="checkbox" name="itemRecommend" value="adolescence" >청소년기 
						<input type="checkbox" name="itemRecommend" value="adultWomen" >성인여자 <br />
						<input type="checkbox" name="itemRecommend" value="adultMen" >성인남자 
						<input type="checkbox" name="itemRecommend" value="middleWomen" >중년여자 
						<input type="checkbox" name="itemRecommend" value="middleMen" >중년남자 <br />
						<input type="checkbox" name="itemRecommend" value="oldWomen" >고령여자 
						<input type="checkbox" name="itemRecommend" value="oldMen" >고령남자 <br />
					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-9">
							<input type="submit" class="btn btn-success" value="수정완료" /> 
							<a href="${pageContext.request.contextPath}/item/list" class="btn btn-primary">홈으로</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>