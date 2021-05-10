<%@page import="java.util.List"%>
<%@page import="review.Review"%>
<%@page import="review.ReviewDAO"%>
<%@page import="review.ReviewRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Review review = new Review();
	ReviewDAO dao = new ReviewDAO();
	ReviewRepository rr = new ReviewRepository(dao);
	List<Review> list = rr.reviewRead();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="css/bulletin-board.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>Review</title>
</head>
<body class="animsition">
<section id="team" class="pb-5">
    <div class="container">
        <h5 class="section-title h1">Review</h5>
        <a href="index.jsp">HOME</a>
        <div class="row">
       		<%
       			if (list != null) {
            		for (int i = list.size() - 1; i >= 0; i--) {
            			review = list.get(i);
            %>
			            <!-- Team member -->
			           	<div class="col-xs-12 col-sm-6 col-md-4">
			                <div class="image-flip" >
			                    <div class="mainflip flip-0">
			                        <div class="frontside">
			                            <div class="card">
			                                <div class="card-body text-center">
			                                    <p><img class=" img-fluid" src="${pageContext.request.contextPath}/imageUpload/<%= review.getFileName() %>" alt="card image"></p>
			                                    <p> <%= review.getFileName() %>
			                                    <h4 class="card-title"><%= review.getId() %></h4>
			                                    <p class="card-text"><%= review.getText() %></p>
			                                    <a href="https://www.fiverr.com/share/qb8D02" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
			                                </div>
			                            </div>
			                        </div>
			                        <div class="backside">
			                            <div class="card">
			                                <div class="card-body text-center mt-4">
			                                    <h4 class="card-title"><%= review.getId() %></h4>
			                                    <p class="card-text"><%= review.getText() %></p>
			                                </div>
			                            </div>
			                        </div>
			                    </div>
			                </div>
			            </div>
			            <!-- ./Team member -->
            <%
            		}
       			}
            %>
        </div>
    </div>
    <form action="/shopping_mall/reviewUpload" method="post" enctype="multipart/form-data">
		아이디:<br>
		<input type="text" name="id" maxlength="30" placeholder="아이디" required/> <br>
		내용:<br>
		<input type="text" name="text" placeholder="후기" required/> <br><br>
		<input type="file" name="file" accept="image/*" onchange="chk_file_type(this)" required/> <br>
		<input type="submit" value="업로드">
</form>
</section>
</body>
</html>