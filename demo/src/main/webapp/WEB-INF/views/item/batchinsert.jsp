<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>물품일괄등록</title>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body>
	<div class="container">
	
	<form action="${pageContext.request.contextPath}/item/batchinsert" method="post">
		
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
				<c:forEach var="i" begin="1" end="5" step="1">
				<tr>
					<td><input type="text" name="code[]" /></td>
					<td><input type="text" name="name[]"  /></td>
					<td><input type="text" name="price[]" value="15000" /></td>
					<td><input type="text" name="quantity[]" /></td>
					<td><input type="text" name="category[]"  /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="submit" value="일괄추가" />
	</form>
		
	</div>
	
</body>
</html>

