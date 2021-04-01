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

<style type="text/css">
	.page {
	display: flex;
	justify-content: center;
	}
	
	.search {
	display: flex;
	justify-content: space-between;
	margin: 17px 17px;
	}
	
	.search-text {
	margin-right: 5px;
	height: 40px;
	width: 200px;
	border:2px solid;
	border-radius: 5px;
	}
	
	.insert {
	padding-bottom: 15px;
	}
</style>

</head>

<body>

<div class="search">
	<form action="${pageContext.request.contextPath}/member/list" method="get" class="search">
		<input type="text" class="search-text" name="txt" placeholder="검색" />
		<input type="submit" class="btn btn-outline-dark" value="검색" />
	</form>
	</div>
	<div class="container">
		<a href="${pageContext.request.contextPath}/admin" class="btn btn-primary">관리자 페이지</a>
		<a href="${pageContext.request.contextPath}/member/join" class="btn btn-success">등록</a>
		<hr />
		<table class="table table-hover">
			<thead>
				<tr>
					<th>멤버번호</th>
					<th>아이디</th>
					<th>암호</th>
					<th>이름</th>
					<th>주소</th>
					<th>휴대폰</th>
					<th>이메일</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${!empty list}">
				<c:forEach var="obj" items="${list}">
				<tr>
					<td>${obj.memberNum}</td>
					<td>${obj.userId}</td>
					<td>${obj.userPass}</td>
					<td>${obj.userName}</td>
					<td>${obj.userAdress}</td>
					<td>${obj.userPhone}</td>
                   	<td>${obj.userEmail}</td>
					<td>
						<form action="${pageContext.request.contextPath}/member/delete" 
						method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<input type="hidden" name="no" value="${obj.memberNum}" />
						<!-- 최소의 정보로 삭제하기 위해 USERID만 쓰기위해 숨겨놓는다.  -->
						<input type="submit" value="삭제" />
						</form>
						<form action="${pageContext.request.contextPath}/member/update"
						method="get">
						<input type="hidden" name="no" value="${obj.memberNum}" />
						<input type="submit" value="수정" />
						</form>
						<%-- <a href="${pageContext.request.contextPath}/customer/update?
						userid=${obj.userid}"></a> =>a tag방식 --%>
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
	</div>
	
	<div class="page" id="pagination-div"></div>

	<!-- jquery cdn -->		
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<!-- twbspagination cdn -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js"></script>
	
	<script>
		$(function(){
			    $('#pagination-div').twbsPagination({
				    totalPages: Number('${totPages}'),
		            visiblePages: 10,
		            startPage : Number('${param.page}'),
		            initiateStartPageClick :false,
		            onPageClick: function (event, page) {
		            window.location.href = "${pageContext.request.contextPath}/member/list?txt="+'${param.txt}'+ "&page="+page;
		            }
			    });
			});	
	</script>
</body>
</html>