<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>리뷰 업로드</title>
</head>
<body>
	<form action="/shopping_mall/imageUpload.jsp" method="post" enctype="multipart/form-data">
		아이디:<br>
		<input type="text" name="id" maxlength="30" placeholder="아이디" required/> <br>
		내용:<br>
		<input type="text" name="text" placeholder="후기" required/> <br><br>
		<input type="file" name="file" accept="image/*" onchange="chk_file_type(this)" required/> <br>
		<input type="submit" value="업로드">
		
	</form>
<!-- 	<script type="text/javascript">
		function chk_file_type(obj) {
 			var file_kind = obj.value.lastIndexOf('.');
 			var file_name = obj.value.substring(file_kind+1,obj.length);
 			var file_type = file_name.toLowerCase();
	 		var check_file_type=new Array();​

 			check_file_type=['jpg','gif','png','jpeg','bmp'];

	 		if(check_file_type.indexOf(file_type)==-1){
  				alert('이미지 파일만 선택할 수 있습니다.');
 				var parent_Obj=obj.parentNode
 				var node=parent_Obj.replaceChild(obj.cloneNode(true),obj);
  				return false;
			}
 		}
	</script> -->
</body>
</html>