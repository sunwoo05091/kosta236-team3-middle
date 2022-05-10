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
</style>
</head>
<body background="ECF1F8">
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link active" href="#">Home
            <span class="visually-hidden">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <a class="dropdown-item" href="#">Something else here</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Separated link</a>
          </div>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-sm-2" type="text" placeholder="Search">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<ul class="nav nav-pills flex-column">
  <li class="nav-item">
    <a class="nav-link " href="listCommunityAction.do">중고거래게시판</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="listCommunityClubAction.do">동아리게시판</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="listCommunityCarfullAction.do">카풀게시판</a>
  </li>
  
</ul>
<ol class="breadcrumb">
  <li class="breadcrumb-item"><a href="#">Home</a></li>
  <li class="breadcrumb-item"><a href="#">Library</a></li>
  <li class="breadcrumb-item active">Data</li>
</ol>

<%-- <form action="updateTradeAction.do" method="post">
	<input type="hidden" name="cm_no" value="${community.cm_no }">
	물품명 : <input type="text" name="cm_title"><br>
	가격 : <input type="text" name="cm_price"><br>
	파일 : <input type="file" name="cm_fname"><br>
	내용 <br>
	<textarea rows="6" cols="70" name="cm_contents"></textarea>
	<br>
	<input type="submit" value="수정완료">
</form> --%>

<form action="updateClubAction.do" method="post" enctype="multipart/form-data">
    <input type="hidden" name="cm_no" value="${community.cm_no}">
    <p>${community.cm_no}</p>
	    <div class="form-group">
	      <label for="exampleInputEmail1" class="form-label mt-4">제목</label>
	      <input type="text" name="cm_title" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="제목을 입력하세요" value="${community.cm_title} ">
	      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	    </div>
	    <div class="form-group">
	      <label for="exampleTextarea" class="form-label mt-4">내용</label>
	      <textarea class="form-control" name="cm_contents" id="exampleTextarea" rows="3"></textarea>
	    </div>
	    <div class="form-group">
	      <label for="exampleSelect1" class="form-label mt-4">Example select</label>
	      <select class="form-select" id="exampleSelect1" name="cm_state">
	        <option value="모집중">모집중</option>
	        <option value="모집완료">모집완료</option>
	      </select>
    	</div>
	    <div class="form-group">
	      <label for="formFile" class="form-label mt-4">이미지 업로드</label>
	      <input class="form-control" type="file" name="cm_fname" id="formFile" value="${community.cm_fname }">
	    </div>
    <input class="btn btn-outline-success" type="submit" value="수정 완료" style="margin-left: 620px; margin-top: 20px; size: 100px;">
</form>
</body>
</html>