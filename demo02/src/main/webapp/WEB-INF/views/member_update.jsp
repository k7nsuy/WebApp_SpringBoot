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
			<h3>UPDATE</h3>
			<hr>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<form action="${pageContext.request.contextPath}/member/update"
					method="post" enctype="multipart/form-data">

					<div class="row" style="margin-bottom: 5px">
					
						<label for="labelId" class="col-sm-3 col-form-label">아이디</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="userid"
								value="${map.USERID}" placeholder="아이디를 입력 하세요." readonly /><br />
						</div>

						<label for="labelname" class="col-sm-3 col-form-label">*이름</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="username"
								value="${map.USERPW}" placeholder="이름을 입력 하세요." autofocus /><br />
						</div>

						<label for="labelphone" class="col-sm-3 col-form-label">*생년월일</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="userbirth"
								value="${map.USERBIRTH}" placeholder="생년월일을 입력 하세요." autofocus /><br />
						</div>
						
						<label for="labelpw1" class="col-sm-3 col-form-label">등록일
							</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" name="regdate"
								value="${map.USEREGDATE}" readonly /><br />
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-9">
							<input type="submit" class="btn btn-success" value="수정완료" /> <a
								href="${pageContext.request.contextPath}/member/main" class="btn btn-primary">홈으로</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>