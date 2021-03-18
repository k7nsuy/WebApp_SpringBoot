<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	<script>
	$(function () {
		Swal.fire({
			position: 'center',
			icon: 'success',
			title: '${message}',
			showConfirmButton: true,
		}).then((result) => {
			location.replace('${pageContext.request.contextPath}${url}');
		});
	});
	</script>
</head>
</html>