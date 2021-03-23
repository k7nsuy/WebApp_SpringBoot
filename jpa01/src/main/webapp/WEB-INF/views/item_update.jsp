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

					<div class="row" style="margin-bottom: 5px">
					
						<label for="labelId" class="col-sm-3 col-form-label">물품번호</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="no"
								value="${vo.no}" readonly /><br />
						</div>
					
						<label for="labelId" class="col-sm-3 col-form-label">물품명</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="name"
								value="${vo.name}" /><br />
						</div>

						<label for="labelname" class="col-sm-3 col-form-label">물품가격</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="price"
								value="${vo.price}" autofocus /><br />
						</div>

						<label for="labelphone" class="col-sm-3 col-form-label">물품수량</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="quantity"
								value="${vo.quantity}" autofocus /><br />
						</div>
						
						<label for="labelphone" class="col-sm-3 col-form-label">등록일</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="itmdate"
								value="${vo.itmdate}" autofocus readonly /><br />
						</div>
						
					</div>
					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-9">
							<input type="submit" class="btn btn-success" value="수정완료" /> 
							<a href="${pageContext.request.contextPath}/main" class="btn btn-primary">홈으로</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>