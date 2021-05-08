<%@page import="java.util.List"%>
<%@page import="review.Review"%>
<%@page import="review.ReviewDAO"%>
<%@page import="review.ReviewRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="css/bulletin-board.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>Review</title>
</head>
<body>
<!-- Team -->
<section id="team" class="pb-5">
    <div class="container">
        <h5 class="section-title h1">Review</h5>
        <div class="row">
            <!-- Team member -->
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="image-flip" >
                    <div class="mainflip flip-0">
                        <div class="frontside">
                            <div class="card">
                                <div class="card-body text-center">
                                    <p><img class=" img-fluid" src="https://sunlimetech.com/portfolio/boot4menu/assets/imgs/team/img_01.png" alt="card image"></p>
                                    <h4 class="card-title">앞쪽 이름</h4>
                                    <p class="card-text">제품 이름</p>
                                    <a href="https://www.fiverr.com/share/qb8D02" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="backside">
                            <div class="card">
                                <div class="card-body text-center mt-4">
                                    <h4 class="card-title">뒤쪽 이름</h4>
                                    <p class="card-text">후기 내용입니다. 랄랄랄랄랄라~~~~~~</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ./Team member -->
            <!-- Team member -->
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="image-flip" >
                    <div class="mainflip flip-0">
                        <div class="frontside">
                            <div class="card">
                                <div class="card-body text-center">
                                    <p><img class=" img-fluid" src="https://sunlimetech.com/portfolio/boot4menu/assets/imgs/team/img_01.png" alt="card image"></p>
                                    <h4 class="card-title">앞쪽 이름</h4>
                                    <p class="card-text">제품 이름</p>
                                    <a href="https://www.fiverr.com/share/qb8D02" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="backside">
                            <div class="card">
                                <div class="card-body text-center mt-4">
                                    <h4 class="card-title">뒤쪽 이름</h4>
                                    <p class="card-text">후기 내용입니다. 랄랄랄랄랄라~~~~~~</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ./Team member -->
            <!-- Team member -->
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="image-flip" >
                    <div class="mainflip flip-0">
                        <div class="frontside">
                            <div class="card">
                                <div class="card-body text-center">
                                    <p><img class=" img-fluid" src="https://sunlimetech.com/portfolio/boot4menu/assets/imgs/team/img_01.png" alt="card image"></p>
                                    <h4 class="card-title">앞쪽 이름</h4>
                                    <p class="card-text">제품 이름</p>
                                    <a href="https://www.fiverr.com/share/qb8D02" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="backside">
                            <div class="card">
                                <div class="card-body text-center mt-4">
                                    <h4 class="card-title">뒤쪽 이름</h4>
                                    <p class="card-text">후기 내용입니다. 랄랄랄랄랄라~~~~~~  랄랄랄랄랄라~~~~~~  랄랄랄랄랄라~~~~~~</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ./Team member -->
            <%
	            ReviewDAO dao = new ReviewDAO();
	        	ReviewRepository rr = new ReviewRepository(dao);
	        	List<Review> list = rr.reviewRead();
            	for (int i = 0; i < list.size(); i++) {
            		String name = list.get(i).getId();
            		String filePath = list.get(i).getFilePath();
            		String text = list.get(i).getText();
            %>
		            <!-- Team member -->
		           	<div class="col-xs-12 col-sm-6 col-md-4">
		                <div class="image-flip" >
		                    <div class="mainflip flip-0">
		                        <div class="frontside">
		                            <div class="card">
		                                <div class="card-body text-center">
		                                    <p><img class=" img-fluid" src="https://sunlimetech.com/portfolio/boot4menu/assets/imgs/team/img_01.png" alt="card image"></p>
		                                    <h4 class="card-title">name</h4>
		                                    <p class="card-text">text</p>
		                                    <a href="https://www.fiverr.com/share/qb8D02" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
		                                </div>
		                            </div>
		                        </div>
		                        <div class="backside">
		                            <div class="card">
		                                <div class="card-body text-center mt-4">
		                                    <h4 class="card-title">name</h4>
		                                    <p class="card-text">text</p>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
		            <!-- ./Team member -->
            <%
            	}
            %>
        </div>
    </div>
</section>
<!-- Team -->
</body>
</html>