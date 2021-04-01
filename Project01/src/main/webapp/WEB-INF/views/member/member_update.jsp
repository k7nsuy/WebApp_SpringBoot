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
		<h2>정보 수정</h2>
		<div style="width: 600px; padding: 30px; border: 1px solid #cccccc">
			
			<form action="${pageContext.request.contextPath}/member/update"
				method="post" enctype="multipart/form-data">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					멤버번호 : <input type="text" name="memberNum" value="${vo2.memberNum}"
					readonly /><br />
					아이디 : <input type="text" name="userId" value="${vo2.userId}" /><br /> 
					비밀번호 : <a href="${pageContext.request.contextPath}/member/changepass?no=${vo2.memberNum}">비밀번호변경</a> <br /> 
					이름 : <input type="text" name="userName"
					value="${vo2.userName}" /><br /> 
					주소 : <input type="text"
					name="userAdress" value="${vo2.userAdress}" /><br /> 
					연락처 : <input class="form-control" name="userPhone" type="tel" placeholder="010-0000-0000" 
		        		 pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" value="${vo2.userPhone}" required ><br /> 
					E-mail : <input type="email"
					name="userEmail" value="${vo2.userEmail}" /><br /> 
					
					<hr />
				
				<input type="submit" class="btn btn-success" value="회원정보수정" /> 
				<a href="${pageContext.request.contextPath}/member/manage" class="btn btn-primary">Admin Page</a>
			</form>
		
		</div>
		
	</div>
</body>
</html>