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
  <h2>체인점 등록</h2>
  <form action="shopRegister" method="post">
    <div class="form-group">
      <label for="shopName">체인점이름:</label>
      <input type="text" class="form-control" id="shopName" name="shopName">
    </div>
    <div class="form-group">
      <label for="shopAddress">주소:</label>
      <input type="text" class="form-control" id="shopAddress" name="shopAddress">
    </div>
    <div class="form-group">
      <label for="shopTel">전화번호:</label>
      <input type="text" class="form-control" id="shopTel" name="shopTel">
    </div>
    <div class="form-group">
      <label for="shopLat">위도(lat):</label>
      <input type="text" class="form-control" id="shopLat" name="shopLat">
    </div>
    
    <div class="form-group">
      <label for="shopLng">경도(lng):</label>
      <input type="text" class="form-control" id="shopLng" name="shopLng">
    </div>
    
    
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>
