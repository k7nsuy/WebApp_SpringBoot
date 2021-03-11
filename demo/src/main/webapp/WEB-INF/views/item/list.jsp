<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/searchbar.css"
	rel="stylesheet" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<form action="${pageContext.request.contextPath}/item/list" method="get" style="padding:30px">
	<input type="hidden" name="page" value="1" />
		
		<select name="type" class="form-control-lg" >
			<option value="code" ${param.type == 'code' ? 'selected="selected"':''}>code</option>
			<option value="name" ${param.type == 'name' ? 'selected="selected"':''}>name</option>
			<option value="category" ${param.type == 'category' ? 'selected="selected"':''}>category</option>
			<!-- type이 코드면 selected 아니면 null -->
		</select>
     
        <input type="text" name="text" class="searchTerm" placeholder="What are you looking for?">
		<input type="submit" value="검색" class="btn btn-secondary" />
		<a href="${pageContext.request.contextPath}/item/insert" class="btn btn-success">등록</a>
		<a href="${pageContext.request.contextPath}/customer/home" class="btn btn-primary">홈으로</a>
	</form>
	
	<form action="${pageContext.request.contextPath}/item/batchdelete" method="post"
	id="form">
		<input type="button" name="btn" value="일괄수정" id="btn" class="btn btn-warning" />
		<input type="submit" name="btn" value="일괄삭제" class="btn btn-danger" />
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>물품코드</th>
					<th>물품명</th>
					<th>물품가격</th>
					<th>물품수량</th>
					<th>등록일</th>
					<th>물품분류</th>
					<!-- <th>비고</th> -->
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty list}">
				<c:forEach var="vo" items="${list}">
				<tr>
					<td>
						<input type="checkbox" name="chk[]" value="${vo.code}" />
						${vo.code}
					</td>
					<td>${vo.name}</td>
					<td>${vo.price}</td>
					<td>${vo.quantity}</td>
					<td>${vo.regdate}</td>
					<td>${vo.category}</td>
					<%-- <td>
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
						<a href="${pageContext.request.contextPath}/customer/update?
						userid=${obj.userid}"></a> =>a tag방식
					</td> --%>
				</tr>
				</c:forEach>
				</c:if>
				<c:if test="${empty list}">
					<tr>
						<td colspan="6">자료가 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		</form>
		<a href="${pageContext.request.contextPath}/item/batchinsert" class="btn-outline-primary">일괄추가</a>
		 <ul id="pagination-demo" class="pagination justify-content-center"></ul>
	</div>
		<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/jquery.twbsPagination.min.js"></script>
		<script>
    	$(function(){
    	    $('#pagination-demo').twbsPagination({
				totalPages   : Number('${cnt}'),
				visiblePages : Number(10),
				startPage    : Number('${param.page}'),
				initiateStartPageClick : false,
				onPageClick: function (event, page) {
					window.location.href = "${pageContext.request.contextPath}/item/list?page=" + page + 
							"&type=${param.type}&text=${param.text}";
		/* 1page에서의 검색어가 2page에도 남아 있게 해야 검색결과가 유지되므로 위의 코드 추가 */
				}
			});
    	    //태그중에서 id가 btn인 것을 클릭하게 되면,
    	    $('#btn').click(function() {
    	    	// 태그중에서 id가 form인것의 속성 action을 변경
    	    	$('#form').attr('action',
    	    	'${pageContext.request.contextPath}/item/batchupdate');
    	    $('#form').submit();
    	    });
    	    
    	});
	</script>
</body>
</html>