<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
  <title>Recipe Register</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>레시피 등록</h2>
  <form action="recipeRegister" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="recipeName">요리이름:</label>
      <input type="text" class="form-control" id="recipeName" name="recipeName">
    </div>
    <div class="form-group">
      <label for="recipeIngredient">재료:</label>
      <input type="text" class="form-control" id="recipeIngredient" name="recipeIngredient">
    </div>
    <div class="form-group">
	  <label for="comment">조리법:</label>
	  <textarea class="form-control" rows="10" id="recipeCookingorder" name="recipeCookingorder"></textarea>
	</div>
	<div class="form-group">
      <label for="recipeImg">사진등록</label>
      <input type="file" class="form-control" id="uploadFile" name="uploadFile">
    </div>
    
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>
