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
<title>Ajax JOIN</title>
</head>
<body>
	<div class="container">

		<div style="margin-top: 30px">
			<h3>Join</h3>
			<hr>
		</div>
		<div class="row">
			<div class="col-sm-4">

					<div class="row" style="margin-bottom: 5px">
					
						<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}" />
							<!-- sercurity를 위해 위의 코드를 추가해 준다. -->
						<label class="col-sm-3 col-form-label">아이디</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="userid"
								id="userid" placeholder="아이디를 입력 하세요." autofocus /><br />
						</div>

						<label class="col-sm-3 col-form-label">비밀번호</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" name="userpw"
								id="userpw" placeholder="비밀번호를 입력 하세요." autofocus /><br />
						</div>

					</div>

					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-9">
							<input type="submit" id="button" class="btn btn-success" value="회원가입" /> <a
								href="${pageContext.request.contextPath}/member/main" class="btn btn-primary">홈으로</a>
						</div>
					</div>
			</div>
		</div>
	</div>

</body>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(function(){
			$('#button').click(function(){
				const userid = $('#userid').val();
				const userpw = $('#userpw').val();
				const header = '${_csrf.headerName}';
				const token = '${_csrf.token}';
				
				$.ajax({
					url: "${pageContext.request.contextPath}/rest/join.json",
					dataType : 'json',
					data : JSON.stringify({userid:userid, userpw:userpw}),
					beforeSend : function(xhr){   // 데이터를 전송하기 전에 헤더에 csrf값 설정
						xhr.setRequestHeader(header, token);
			        },
					processData: false, // 비동기 파일 업로드시 꼭 설정해줘야 하는 속성
					contentType: "application/json; charset=utf-8",
					type: 'POST',
					success: function (res) {
					    console.log(res);
	                    alert("success");
	                    window.location.href='${pageContext.request.contextPath}/member/main';
					},error: function (xhr) {
					  	console.log(xhr.responseText)
						alert("fail");
					} 
				});
			});
		});
	
	</script>
	
</html>