<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Insert</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/item/insert" method="post" 
	enctype="multipart/form-data">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		물품명 : <input type="text" name="itemName" > <br />
		물품가격 : <input type="text" name="itemPrice" > <br />
		물품수량 : <input type="text" name="itemQuantity" > <br />
		물품영양정보 : <textarea rows="2" name="itemDetail" id="summernote" /></textarea><br />
		물품추천 : <input type="checkbox" name="itemRecommend" value="infancy" >유아기 
		<input type="checkbox" name="itemRecommend" value="adolescence" >청소년기 
		<input type="checkbox" name="itemRecommend" value="adultWomen" >성인여자 <br />
		<input type="checkbox" name="itemRecommend" value="adultMen" >성인남자 
		<input type="checkbox" name="itemRecommend" value="middleWomen" >중년여자 
		<input type="checkbox" name="itemRecommend" value="middleMen" >중년남자 <br />
		<input type="checkbox" name="itemRecommend" value="oldWomen" >고령여자 
		<input type="checkbox" name="itemRecommend" value="oldMen" >고령남자 <br />
		이미지등록 : <input type="file" name="image"> <br />
		<input type="submit" value="물품등록" >
	</form>
	<script>
      $('#summernote').summernote({
        placeholder: '내용을 입력하세요',
        tabsize: 1,
        height: 210
      });
    </script>
</body>
</html>