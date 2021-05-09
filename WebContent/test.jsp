<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
	<c:forEach var="product" items="${ product_list }">
		${ product.name }
		${ product.photo_1 }
		<img src="${ product.photo_1 }"/>
	</c:forEach>
</body>
</html>