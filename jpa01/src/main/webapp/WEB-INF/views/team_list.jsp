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
					<th>팀아이디</th>
					<th>팀이름</th>
					<th>등록일</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${!empty list}">
				<c:forEach var="obj" items="${list}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/team/userlist?teamid=${obj.id}">${obj.id}</a></td>
					<td>${obj.name}</td>
					<td>${obj.date}</td>
					<td>
						<form action="${pageContext.request.contextPath}/team/delete" 
						method="post">
						<input type="hidden" name="id" value="${obj.id}" />
						<!-- 최소의 정보로 삭제하기 위해 USERID만 쓰기위해 숨겨놓는다.  -->
						<input type="submit" value="삭제" />
						</form>
						<form action="${pageContext.request.contextPath}/team/update"
						method="get">
						<input type="hidden" name="id" value="${obj.id}" />
						<input type="submit" value="수정" />
						</form>
					</td>
				</tr>
				</c:forEach>
				 </c:if>
	            <c:if test="${empty list}">
	                <tr>
	                    <td colspan="4">자료가 없습니다.</td>
	                </tr>
	            </c:if>
			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/team/insert" class="btn btn-success">등록하기</a>
		<a href="${pageContext.request.contextPath}/home" class="btn btn-primary">홈으로</a>
	</div>
</body>
</html>