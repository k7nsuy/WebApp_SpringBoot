<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">

		<div style="margin-top: 30px">
			<h3>물품등록</h3>
			<hr>
		</div>
		<div class="row">
			<div class="col-sm-4">

					<div class="row" style="margin-bottom: 5px">

						<label for="labelId" class="col-sm-3 col-form-label">물품코드</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" 
								id="code" placeholder="물품코드를 입력 하세요." autofocus /><br />
						</div>

						<label for="labelpw" class="col-sm-3 col-form-label">물품명</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" 
								id="name" placeholder="물품명을 입력 하세요." autofocus /><br />
						</div>

						<label for="labelpw1" class="col-sm-3 col-form-label">가격</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" 
								id="price" placeholder="가격을 입력 하세요." autofocus /><br />
						</div>

						<label for="labelname" class="col-sm-3 col-form-label">수량</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" 
								id="quantity" placeholder="수량을 입력 하세요." autofocus /><br />
						</div>

						<label for="labelphone" class="col-sm-3 col-form-label">분류</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" 
								id="category" placeholder="분류 할 코드를 입력 하세요." autofocus /><br />
						</div>
					</div>

					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-9">
							<input type="submit" class="btn btn-success" id="button" value="등록" /> 
						</div>
					</div>
			</div>
		</div>
	</div>
</body>
<script 
      src="https://code.jquery.com/jquery-3.6.0.min.js" type="text/javascript"></script>
       <script type="text/javascript">
       $(function(){
		    
			$('#button').click(function(){ //등록버튼일 클릭되면
				const code = $('#code').val(); //물품코드에 입력한 값 가져오기
				const name = $('#name').val(); //물품내용에 입력한 값 가져오기
				const price = $('#price').val(); //물품내용에 입력한 값 가져오기
				const quantity = $('#quantity').val(); //물품내용에 입력한 값 가져오기
				const category = $('#category').val(); //물품내용에 입력한 값 가져오기
				
				if(code.length == 0){
					alert('코드를 입력하세요.');
					$('#code').focus();
					return false;
				}
				
				if(name.length == 0){
					alert('물품명을 입력하세요.');
					$('#name').focus();
					return false;
				}
				
				$.ajax({
					url: "${pageContext.request.contextPath}/item/insert1.json",
					dataType : 'json',
					data : JSON.stringify({code:code, name:name, price:price, quantity:quantity, category:category}),
					processData: false,
					contentType: "application/json; charset=utf-8",
					type: 'POST',
					success: function (res) {
					    console.log(res);
	                    alert("success");
					},error: function (xhr) {
					  alert(xhr.responseText);
					} 
				});
				/* $.post('${pageContext.request.contextPath}/item/insert.json', {code:code, name:name, price:price, quantity:quantity, category:category}, function(res){
					console.log(res);
				},'json');  */
			});
	
		});
  	</script>
</html>