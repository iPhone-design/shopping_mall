<%@page import="review.Review"%>
<%@page import="review.ReviewDAO"%>
<%@page import="review.ReviewRepository"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 업로드 중</title>
</head>
<body>
	<%
		String uploadDir = this.getClass().getResource("").getPath();
		uploadDir = uploadDir.substring(1, uploadDir.indexOf(".metadata")) + "shopping_mall/WebContent/imageUpload";
		out.print("절대경로 : " + uploadDir + "<br>");
		
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		
		MultipartRequest multipartRequest = new MultipartRequest(request, uploadDir, maxSize, encoding, new DefaultFileRenamePolicy());
		uploadDir += multipartRequest.getOriginalFileName("file");
		
		String id = multipartRequest.getParameter("id");
		String text = multipartRequest.getParameter("text");
		out.println(id);
		out.println(text);
		
		ReviewDAO dao = new ReviewDAO();
		ReviewRepository rr = new ReviewRepository(dao);
		
		rr.reviewAdd(new Review(id, uploadDir, text));
	%>
</body>
</html>