<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./CSS/bootstrap.min.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<div class="container">
		<div style="width:600px; padding:30px; margin:30px; border:1px solid #cccccc">
		<h3>글쓰기</h3>
			<form action="${pageContext.request.contextPath}/board/insert" method="post">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}" />
				제목 : <input style="margin:10px" type="text" name="brdtitle" placeholder="제목을 입력하세요." /><br />
				내용 : <textarea rows="6" name="brdcontent" id="summernote" /></textarea><br />
				작성자 : <input type="text" name="brdwriter" placeholder="작성자" /><br />
				<input style="margin:20px" type="submit" class="btn btn-success" value="글쓰기" />
			</form>
		</div>
	</div>
	
	<script>
      $('#summernote').summernote({
        placeholder: '내용을 입력하세요.',
        tabsize: 2,
        height: 160
      });
    </script>
</body>
</html>