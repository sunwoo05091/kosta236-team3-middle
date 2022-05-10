<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글쓰기</h3>
<hr>
<form action="insertReferenceroomAction.do" method="post" enctype="multipart/form-data"> 

	<!-- 사원번호 : <input type="text" name="e_no"><br>  -->
	제목 : <input type="text" name="b_title"><br>	
	파일 : <input type="file" name="b_fname"><br>
	내용 <br>
	<textarea rows="6" cols="70" name="b_contents"></textarea>
	<br>
	<input type="submit" value="등록">
</form>
</body>
</html>