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
					<th>물품코드</th>
					<th>물품명</th>
					<th>물품가격</th>
					<th>물품수량</th>
					<th>등록일</th>
					<th>물품분류</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.code}</td>
					<td>${vo.name}</td>
					<td>${vo.price}</td>
					<td>${vo.quantity}</td>
					<td>${vo.regdate}</td>
					<td>${vo.category}</td>
					<td>
						<form action="${pageContext.request.contextPath}/item/delete" 
						method="post">
						<input type="hidden" name="code" value="${vo.code}" />
						<!-- 최소의 정보로 삭제하기 위해 USERID만 쓰기위해 숨겨놓는다.  -->
						<input type="submit" value="삭제" />
						</form>
						<form action="${pageContext.request.contextPath}/item/update"
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