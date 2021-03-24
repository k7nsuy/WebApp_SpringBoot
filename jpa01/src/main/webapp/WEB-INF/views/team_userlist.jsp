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
		<h3>${team.id} / ${team.name}</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>아이디</th>
					<th>암호</th>
					<th>이름</th>
					<th>이미지</th>
					<th>등록일</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${!empty team.users}">
				<c:forEach var="obj" items="${team.users}">
				<tr>
					<td>${obj.userid}</td>
					<td>${obj.userpw}</td>
					<td>${obj.username}</td>
					<td>
						<c:if test="${obj.base64 ne null}">
                    		<img src="data:image/png;base64,${obj.base64}" width="50px" height="50px" />
                    	</c:if>
	                    	
                    	<c:if test="${obj.base64 eq null}">
                    		NO이미지
                    	</c:if>
                   	</td>
                   	<td>${obj.userdate}</td>
					<td></td>
					<td>
						<form action="${pageContext.request.contextPath}/user/delete" 
						method="post">
						<input type="hidden" name="userid" value="${obj.userid}" />
						<!-- 최소의 정보로 삭제하기 위해 USERID만 쓰기위해 숨겨놓는다.  -->
						<input type="submit" value="삭제" />
						</form>
						<form action="${pageContext.request.contextPath}/user/update"
						method="get">
						<input type="hidden" name="userid" value="${obj.userid}" />
						<input type="submit" value="수정" />
						</form>
						<%-- <a href="${pageContext.request.contextPath}/customer/update?
						userid=${obj.userid}"></a> =>a tag방식 --%>
					</td>
				</tr>
				</c:forEach>
				 </c:if>
	            <c:if test="${empty team.users}">
	                <tr>
	                    <td colspan="4">자료가 없습니다.</td>
	                </tr>
	            </c:if>
			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/home" class="btn btn-primary">홈으로</a>
	</div>
</body>
</html>