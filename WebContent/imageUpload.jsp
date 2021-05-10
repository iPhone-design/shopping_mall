<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
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
		out.println(uploadDir);
		
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		
		MultipartRequest multipartRequest = new MultipartRequest(request, uploadDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String id = multipartRequest.getParameter("id");
		String text = multipartRequest.getParameter("text");
		String fileName = multipartRequest.getOriginalFileName("file");
		String now = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss_").format(new Date());
		
		File file = new File(uploadDir + "/" + fileName);
		out.println(uploadDir + fileName);
		file.renameTo(new File(uploadDir + "/" + now + fileName));
		out.println(uploadDir + now + fileName);
		
		ReviewDAO dao = new ReviewDAO();
		ReviewRepository rr = new ReviewRepository(dao);
		rr.reviewAdd(new Review(id, now + fileName, text));
		
		Thread.sleep(5000);
		response.sendRedirect("bullentin-board.jsp");
	%>
</body>
</html>