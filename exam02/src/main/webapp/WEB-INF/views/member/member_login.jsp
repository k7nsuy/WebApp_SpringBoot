<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="padding: 30px 0 0 0">
		<h3>Login</h3>
		<hr>
		<div class="row">
			<div class="col-sm-4">
				<form action="${pageContext.request.contextPath}/loginProcess" method="post">
					<div class="row" style="margin-bottom: 5px">
						<label class="col-sm-3 col-form-label">아이디</label>
						<div class="col-sm-9">
							<input class="form-control" type="text" name="userid"
								placeholder="아이디를 입력 하세요." autofocus> <br />
						</div>
						<label class="col-sm-3 col-form-label">비밀번호</label>
						<div class="col-sm-9">
							<input class="form-control" type="password" name="userpw"
								placeholder="비밀번호를 입력 하세요."> <br /> <input
								type="submit" class="btn btn-success" value="로그인" />
							<a href="member_main" class="btn btn-primary">홈으로</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>