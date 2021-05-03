<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
  <title>Recipe List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Recipe List</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>사진</th>
        <th>요리이름</th>
        <th>재료</th>
        <th>조리순서</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="recipe">
      <tr>
        <td><img src="/resources/recipe_img/${recipe.recipeImg}" width=200, height=200></td>
        <td>${recipe.recipeName}</td>
        <td>${recipe.recipeIngredient}</td>
        <td>${recipe.recipeCookingorder}</td>
      </tr>
	</c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
