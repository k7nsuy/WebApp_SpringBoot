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
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>아이디</th>
					<th>암호</th>
					<th>이름</th>
					<th>연락처</th>
					<th>등록일</th>
					<th>이미지</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="obj" items="${list}">
				<tr>
					<td>${obj.userid}</td>
					<td>${obj.userpw}</td>
					<td>${obj.username}</td>
					<td>${obj.userphone}</td>
					<td>${obj.userdate}</td>
					<td><img src="${pageContext.request.contextPath}/customer/imagePreview?userid=${obj.userid}" 
					width="50px" height="50px" /></td>
					<td>
						<form action="${pageContext.request.contextPath}/customer/delete" 
						method="post">
						<input type="hidden" name="userid" value="${obj.userid}" />
						<!-- 최소의 정보로 삭제하기 위해 USERID만 쓰기위해 숨겨놓는다.  -->
						<input type="submit" value="삭제" />
						</form>
						<form action="${pageContext.request.contextPath}/customer/update"
						method="get">
						<input type="hidden" name="userid" value="${obj.userid}" />
						<input type="submit" value="수정" />
						</form>
						<%-- <a href="${pageContext.request.contextPath}/customer/update?
						userid=${obj.userid}"></a> =>a tag방식 --%>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="home" class="btn btn-primary">홈으로</a>
	</div>
</body>
</html>