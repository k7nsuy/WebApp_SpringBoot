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
  <h2>Shop List</h2>
  <a href="shopRegister">New</a>
  <table class="table table-hover">
    <thead>
      <tr>
      	<th>No.</th>
        <th>체인점이름</th>
        <th>주소</th>
        <th>전화번호</th>
        <th>위도(lat)</th>
        <th>경도(lng)</th>
     
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="shop">
      <tr>
        
        <td>${shop.shopId}</td>
        <td>${shop.shopName}</td>
        <td>${shop.shopAddress}</td>
        <td>${shop.shopTel}</td>
        <td>${shop.shopLat}</td>
        <td>${shop.shopLng}</td>
       
      </tr>
	</c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
