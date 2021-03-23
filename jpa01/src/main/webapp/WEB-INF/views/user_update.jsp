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
		
		<div style="width: 600px; padding: 30px; border: 1px solid #cccccc">
			
			<form action="${pageContext.request.contextPath}/user/update"
				method="post" enctype="multipart/form-data">
					아이디 : <input type="text" name="userid" value="${map.USERID}"
					readonly /><br /> 
					이름 : <input type="text" name="username"
					value="${map.USERNAME}" /><br /> 
					연락처 : <input type="text"
					name="userphone" value="${map.USERPHONE}" /><br /> 
					등록일 : <input
					type="text" name="userdate" value="${map.USERDATE}" readonly /><br />
					이미지 : <img src="${pageContext.request.contextPath}/customer/imagePreview?userid=
					${map.USERID}" width="50px" height="50px"> <input type="file" name="tmpimg" /><br />
				
				<input type="submit" class="btn btn-success" value="글수정" /> 
				<a href="home" class="btn btn-primary">홈으로</a>
			</form>
		
		</div>
		
	</div>
</body>
</html>