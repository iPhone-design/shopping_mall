<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<link rel="stylesheet" type="text/css" href="css/manage-user.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.css">
</head>
<body>
<div class="form-inner">
	<div class="context">
	<h1>회원 관리</h1>
	<div class="inner-table">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>회원번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>최근 방문일</th>
					<th>회원등급</th>
					<th>정보수정</th>
					<th>계정삭제</th>
		      </tr>
	      </thead>
		<c:forEach var="user_list" items="${ user_list }">
	      <tbody>
	   		<tr>
	   			<td>${user_list.user_num}</td>
	   			<td>${user_list.id}</td>
	   			<td>${user_list.name}</td>
	   			<td>${user_list.birth}</td>
	   			<td>${user_list.phone_num}</td>
	   			<td>${user_list.address}</td>
	   			<td>${user_list.join_date}</td>
	   			<td>${user_list.grade}</td>
	   			<td><a href="manage-user.jsp?user.id=${ user_list.user_num }">[수정]</a></td>
	   			<td><a href="manage-user.jsp?user.id=${ user_list.user_num }">[삭제]</a></td>
	    	</tr>
	      </tbody>
	      </c:forEach>
		</table>
	</div>
	<c:forEach var ="pageNum" begin="1" end="${ pageTotalCount }">
	<a href="manage-user?page=${ pageNum }">[${ pageNum }]</a>
	</c:forEach>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
</body>
</html>