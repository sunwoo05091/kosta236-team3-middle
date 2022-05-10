<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel = "stylesheet" href="Resource/CSS/bootstrap.min.css" type = "text/css">
<link rel = "stylesheet" href="Resource/CSS/bootstrap.css" type = "text/css">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.min.css" type = "text/css">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.css" type = "text/css">
<style type="text/css">
	input {
	margin: 5px;
	
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
    <a class="nav-link active" href="#">전자결재</a>
      <li class="nav-item">
    <a class="nav-link" href="#" onclick="location.href='insertForm.do'">문서 작성</a>
    <a class="nav-link" href="#" onclick="location.href='listAction.do'">문서 조회</a>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">문서함</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#" onclick="location.href='listDocumentSignProgressAction.do'">결재 진행 문서함</a>
      <a class="dropdown-item" href="#" onclick="location.href='listDocumentSignCompleteAction.do'">결재 완료 문서함</a>
      <a class="dropdown-item" href="#" onclick="location.href='listDocumentSignCompanionAction.do'">반려 문서함</a>
      <a class="dropdown-item" href="#" onclick="location.href='listDocumentSignCompleteDepartmentAction.do'">부서 문서함</a>
    </div>
  </li>
</ul>
<ol class="breadcrumb">
  <li class="breadcrumb-item"><a href="#">메인페이지</a></li>
</ol>

	<form action="updateAction.do" method="post">
	<div class="control-group" style="width: 1200px; height: 300px; margin: auto;">
    <label class="control-label" >★수정 가능 항목 : 제목, 내용, 첨부파일★</label><br>
		<br>
		<input type="hidden" name="dc_no" value="${document.dc_no }">
		제목 : <input class="form-control" type="text"  name="dc_title" value="${document.dc_title }"><br>
		내용 : 
		<textarea class="form-control" rows="6" cols="70" name="dc_contents">${document.dc_contents }</textarea><br>
		첨부파일 : 
      	<input class="form-control" type="file"  name="dc_fname" value="${document.dc_fname }"><br>

		<input class="btn" type="submit" value="수정">
		<a class="btn" href="#" onclick=history.back()>취소</a>
		<input class="btn" type="reset" value="초기화">
	</div>
	</form>
	
	


</body>
</html>