<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.min.css" type = "text/css">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.css" type = "text/css">
<link rel = "stylesheet" href="Resource/CSS/bootstrap.min.css" type = "text/css">
<link rel = "stylesheet" href="Resource/CSS/bootstrap.css" type = "text/css">
<style type="text/css">
	.form-group{
		margin-left: 300px;
		width: 600px;
	}
	h3{
		margin-left: 550px;
	}
</style>
</head>
<body>
<h3>글쓰기</h3>
<hr>
<!-- <form action="insertReferenceroomAction.do" method="post" enctype="multipart/form-data"> 

	사원번호 : <input type="text" name="e_no"><br> 
	제목 : <input type="text" name="b_title"><br>	
	파일 : <input type="file" name="b_fname"><br>
	내용 <br>
	<textarea rows="6" cols="70" name="b_contents"></textarea>
	<br>
	<input type="submit" value="등록">
</form> -->

<form action="insertReferenceroomAction.do" method="post" enctype="multipart/form-data">
   
    <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">제목</label>
      <input type="text" name="b_title" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="제목을 입력하세요">
      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
      <label for="exampleTextarea" class="form-label mt-4">내용</label>
      <textarea class="form-control" name="b_contents" id="exampleTextarea" rows="3"></textarea>
    </div>
    <div class="form-group">
      <label for="formFile" class="form-label mt-4">이미지 업로드</label>
      <input class="form-control" type="file" name="b_fname" id="formFile">
    </div>
    <input class="btn btn-outline-success" type="submit" value="등록" style="margin-left: 620px; margin-top: 20px; size: 100px;">
    
</form>

</body>
</html>