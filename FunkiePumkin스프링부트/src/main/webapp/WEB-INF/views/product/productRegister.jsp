<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
  <title>Product Register</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>상품 등록</h2>
  <form action="productRegister" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="memberId">판매자ID:</label>
      <input type="text" class="form-control" id="memberId" name="memberId">
    </div>
    <div class="form-group">
      <label for="productName">상품이름:</label>
      <input type="text" class="form-control" id="productName" name="productName">
    </div>
    <div class="form-group">
      <label for="productPrice">상품가격:</label>
      <input type="text" class="form-control" id="productPrice" name="productPrice">
    </div>
    <div class="form-group">
      <label for="stock">재고:</label>
      <input type="text" class="form-control" id="stock" name="stock">
    </div>
    <div class="form-group">
      <label for="category">카테고리:</label>
      <select id="category" name="category" class="form-control">
      	<option value="과일">과일</option>
      	<option value="채소">채소</option>
      	<option value="허브">허브</option>
      	<option value="식물성 우유">식물성 우유</option>
      	<option value="향신료">향신료</option>
      </select>
    </div>
    <div class="form-group">
      <label for="exp">유통기한:</label>
      <input type="text" class="form-control" id="exp" name="exp">
    </div>
    <div class="form-group">
	  <label for="productDes">상품설명:</label>
	  <textarea class="form-control" rows="10" id="productDes" name="productDes"></textarea>
	</div>
	<div class="form-group">
      <label for="productImg">상품사진:</label>
      <input type="file" class="form-control" id="uploadFile" name="uploadFile">
    </div>
    
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>
