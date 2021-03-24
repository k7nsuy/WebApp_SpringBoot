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
<title>INSERT</title>
</head>
<body>
	<div class="container">

		<div style="margin-top: 30px">
			<h3>INSERT BATCH</h3>
			<hr>
		</div>
		<div class="row">
			<div class="col-sm-4">
			
				<form action="${pageContext.request.contextPath}/team/insertbatch"
					method="post" enctype="multipart/form-data">

					<div class="row" style="margin-bottom: 5px">
					
					<c:forEach var="i" begin="1" end="3" step="1">
					
						<label for="labelId" class="col-sm-3 col-form-label">TeamID</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="id[]"
								id="labelId" placeholder="팀아이디를 입력 하세요." autofocus /><br />
						</div>

						<label for="labelname" class="col-sm-3 col-form-label">TeamName</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="name[]"
								id="labelname" placeholder="팀이름을 입력 하세요." autofocus /><br />
						</div>
						
						<hr />
						
						</c:forEach>
						
					</div>

					<div class="row">

						<div class="col-sm-3"></div>
						<div class="col-sm-9">
							<input type="submit" class="btn btn-success" value="만들기" /> <a
								href="${pageContext.request.contextPath}/home" class="btn btn-primary">홈으로</a>
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>