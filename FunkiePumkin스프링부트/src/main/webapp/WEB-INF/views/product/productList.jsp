<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
  <title>Product List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Product List</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>사진</th>
        <th>판매자ID</th>
        <th>상품이름</th>
        <th>상품가격</th>
        <th>상품설명</th>
        <th>판매량</th>
        <th>재고</th>
        <th>카테고리</th>
        <th>유통기한</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="product">
      <tr>
        <td><img src="/resources/product_img/${product.productImg}" width=200, height=200></td>
        <td>${product.memberId}</td>
        <td>${product.productName}</td>
        <td>${product.productPrice}</td>
        <td>${product.productDes}</td>
        <td>${product.salesAmount}</td>
        <td>${product.stock}</td>
        <td>${product.category}</td>
        <td>${product.exp}</td>
      </tr>
	</c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
