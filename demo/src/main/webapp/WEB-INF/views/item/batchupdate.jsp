<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>물품일괄수정</title>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body>
	<div class="container">
	
	<form action="${pageContext.request.contextPath}/item/batchupdate2" method="post">
		
		<table class="table">
			<thead>
				<tr>
					<th>code</th>
					<th>name</th>
					<th>price</th>
					<th>quantity</th>
					<th>category</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="vo" items="${list }">
				<tr>
					<td><input type="text" name="code[]" value="${vo.code}" readonly /></td>
					<td><input type="text" name="name[]" value="${vo.name}" /></td>
					<td><input type="text" name="price[]" value="${vo.price}" /></td>
					<td><input type="text" name="quantity[]" value="${vo.quantity}" /></td>
					<td><input type="text" name="regdate[]" value="${vo.regdate}" readonly /></td>
					<td><input type="text" name="category[]"  value="${vo.category}" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="submit" class="btn btn-warning" value="일괄수정" />
	</form>
		
	</div>
	
</body>
</html>

