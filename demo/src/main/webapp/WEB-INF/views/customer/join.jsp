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
<title>JOIN</title>
</head>
<body>
	<div class="container"x>

		<div style="margin-top: 30px">
			<h3>Join</h3>
			<hr>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<form action="${pageContext.request.contextPath}/customer/join"
					method="post" enctype="multipart/form-data">

					<div class="row" style="margin-bottom: 5px">
					
						<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}" />
							<!-- sercurity를 위해 위의 코드를 추가해 준다. -->
						<label for="labelId" class="col-sm-3 col-form-label">아이디</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="userid"
								id="labelId" placeholder="아이디를 입력 하세요." autofocus /><br />
						</div>

						<label for="labelpw" class="col-sm-3 col-form-label">비밀번호</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" name="userpw"
								id="labelpw" placeholder="비밀번호를 입력 하세요." autofocus /><br />
						</div>

						<label for="labelpw1" class="col-sm-3 col-form-label">비밀번호
							확인</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" name="userpw1"
								id="labelpw1" placeholder="비밀번호를 다시 입력하세요." autofocus /><br />
						</div>

						<label for="labelname" class="col-sm-3 col-form-label">이름</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="username"
								id="labelname" placeholder="이름을 입력 하세요." autofocus /><br />
						</div>

						<label for="labelphone" class="col-sm-3 col-form-label">연락처</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="userphone"
								id="labelphone" placeholder="휴대번호를 입력 하세요." autofocus /><br />
						</div>
						

						<div>						
						<label for="labelphone" class="col-sm-3 col-form-label">회원등급</label>
						<select name="usergrade">
							<option value="GOLD">GOLD</option>
							<option value="SILVER">SILVER</option>
							<option value="BRONZE">BRONZE</option>
						</select>
						</div>
						
						<label for="labelphone" class="col-sm-3 col-form-label">이미지</label>
						<div class="col-sm-9">
							<input type="file" class="form-control" name="tmpimg"
								id="labelphone" autofocus /><br />
						</div>

					</div>

					<div class="row">

						<div class="col-sm-3"></div>
						<div class="col-sm-9">
							<input type="submit" class="btn btn-success" value="회원가입" /> <a
								href="home" class="btn btn-primary">홈으로</a>
						</div>

					</div>
				</form>
			</div>
		<div class="col-sm-8">8/12</div>
		</div>
	</div>

</body>
</html>