<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
  <title>Order List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Order List</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>주문번호</th>
        <th>회원ID</th>
        <th>배송주소</th>
        <th>연락처</th>
        <th>총가격</th>
        <th>상태</th>
        <th>주문일</th>
        <th>완료</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="order">
      <tr>
      	<td>${order.orderId}</td>
        <td>${order.memberId}</td>
        <td>${order.orderAddr}</td>
        <td>${order.orderPhone}</td>
        <td>${order.totalOrderAmount}</td>
        <td>${order.status}</td>
        <td>${order.orderDate}</td>
        <c:if test="${order.status == '픽업대기'}">
        <td><a href="" id="pickupBtn" data-orderId="${order.orderId}" data-memberId="${order.memberId}">픽업완료</a></td>
        </c:if>
        <c:if test="${order.status == '배송대기'}">
        <td><a href="" id="delieveryBtn" data-orderId="${order.orderId}" data-memberId="${order.memberId}">배송완료</a></td>
        </c:if>
      </tr>
	</c:forEach>
    </tbody>
  </table>
</div>


<script>
$("#pickupBtn").click(function(){
	var orderId = $(this).attr("data-orderId");
	var memberId = $(this).attr("data-memberId");
	var data = {
			orderId : orderId,
			status : 0,
			memberId : memberId
			};

	$.ajax({
		url : "orderCompleted",
		type : "post",
		data : data,
		success : function(result){
			if(result==0) alert("픽업완료");
			else alert("이미 처리됨");
		},
		error : function(){
			alert("오류");
		}
	});
});

$("#delieveryBtn").click(function(){
	var orderId = $(this).attr("data-orderId");
	var memberId = $(this).attr("data-memberId");
	var data = {
			orderId : orderId,
			status : 1,
			memberId : memberId
			};

	$.ajax({
		url : "orderCompleted",
		type : "post",
		data : data,
		success : function(result){
			if(result==0) alert("배송완료");
			else alert("이미 처리됨");
		},
		error : function(){
			alert("오류");
		}
	});
});


</script>

</body>
</html>
