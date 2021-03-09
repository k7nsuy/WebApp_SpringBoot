<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>물품등록</title>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css?ver=1" rel="stylesheet" />
</head>

<body>
	<div class="container">
		<form:form action="${pageContext.request.contextPath}/item/insert" method="post" modelAttribute="vo">
			물품코드 : <form:input type="text" path="code"  /><br />
			물품명 : <form:input type="text" path="name" /><br />
			가격 : <form:input type="text" path="price" /><br />
			수량 : <form:input type="text" path="quantity" /><br />
			분류 : <form:input type="text" path="category" /><br />
			<form:select path="category2" items="${slist}" /><br />
			<form:checkboxes path="category2" items="${slist}" /><br />
			<form:radiobuttons path="category2" items="${slist}" /><br />
			<input type="submit" value="등록" />
		</form:form>
	</div>
</body>
</html>