<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>security_login.jsp</title>
</head>

<body>
    <form action="${pageContext.request.contextPath}/loginProcess" method="post">
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <fieldset style="width:350px">
            <legend>security_로그인</legend>

            <label style="width:80px; display:inline-block">아이디</label>:
            <input type="text" name="username" placeholder="아이디" /><br />
            
            <label style="width:80px; display:inline-block">암호</label>:
            <input type="password" name="password" placeholder="암호" /><br />
            
            <hr />
            <input type="submit" value="로그인" />
        </fieldset>
    </form>
</body>
</html>
