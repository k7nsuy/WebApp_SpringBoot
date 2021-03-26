<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<title>주문</title>
</head>
<body>
	<div class="container">

		<div style="margin-top: 30px">
			<h3>주문</h3>
			<hr>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<form action="${pageContext.request.contextPath}/order/insert"
					method="post" >

					<div class="row" style="margin-bottom: 5px">
					
						<label for="labelId" class="col-sm-3 col-form-label">물품번호</label>
						<div class="col-sm-9">
							${vo.no}<br />
							<input type="hidden" name="itemno" value="${vo.no}" />
						</div>

						<label for="labelname" class="col-sm-3 col-form-label">물품명</label>
						<div class="col-sm-9">
							${vo.name} <br />
						</div>
						<label for="labelname" class="col-sm-3 col-form-label">물품가격</label>
						<div class="col-sm-9">
							${vo.price}<br />
						</div>

						<label  class="col-sm-3 col-form-label">주문수량</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="qnt"
								 placeholder="수량을 입력 하세요." autofocus /><br />
						</div>
					</div>

					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-9">
							<input type="submit" class="btn btn-success" value="주문하기" /> 
							<a href="${pageContext.request.contextPath}/order/itemlist" class="btn btn-primary">이전</a>
							<a href="${pageContext.request.contextPath}/main" class="btn btn-primary">홈으로</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>


</html>