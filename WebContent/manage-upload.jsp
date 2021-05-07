<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="form-inner">
<form class="form">
	<h1>상품 추가</h1>
	<div class="form-group">
		<label>제목</label>
		<input type="text" class="form-control" placeholder="제목" name="product-title"/>
	</div>
	<div class="form-group">
    <label for="InputFile">파일 업로드</label>
    <input type="file" id="InputFile" enctype="multipart/form-data" name="product-file" accept="image/*" onchange="setThumbnail(event);" multiple>
    <div id="image_container"></div>

   	<p class="help-block">제품 사진을 올리세요.</p>
 	 </div>
	 <div class="form-group">
    <div class="input-group">
    <label class="sr-only" for="InputAmount">가격</label>
      <div class="input-group-addon">&#8361;</div>
      <input type="text" class="form-control" id="InputAmount" placeholder="가격" name="product-price">
    </div>
  </div>
	<div class="form-group">
		<label>상세 내용</label>
		<textarea class="form-control" rows="5" placeholder="상세 내용" name="product-content"></textarea>
	</div>
	  <button type="submit" class="btn btn-default">상품 등록</button>
</form>
</div>



