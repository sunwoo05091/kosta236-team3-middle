<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>calendar</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/Resource/CSS/main.js"></script>
<script src="/Resource/CSS/ko.js"></script>
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.min.css" type = "text/css">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.css" type = "text/css">
<link rel = "stylesheet" href="Resource/CSS/bootstrap.min.css" type = "text/css">
<link rel = "stylesheet" href="Resource/CSS/bootstrap.css" type = "text/css">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/main.css" type="text/css">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/schedule.css" type="text/css">

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
<ul class="nav nav-pills flex-column" style="position: absolute;">
	<div class="card bg-light mb-3" style="max-width: 20rem;">
		  <div class="card-body">
		    <svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="100%" height="130" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size:1.125rem;text-anchor:middle">
    			<rect width="100%" height="100%" fill="#868e96"></rect>
    			<text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
  			</svg>
  			<br>
		    <div class="card-text"><div>인사부서</div><div>${emp.grade } ${emp.name }님</div></div>
		  </div>
	</div>
  <li class="nav-item">
    <a class="nav-link active" href="moveSchedule.do">개인 일정</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="insertForm.do">일정 생성</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="listAction.do">일정 조회</a>
  </li>
  <hr style="border: solid 1px gray;">
	<li>분류별 일정</li><br>
	<li style="text-decoration: none;"><a href="TypeScheduleAction.do?s_type=1" id="tag">- 개인</a></li><br>
	<li style="text-decoration: none;"><a href="TypeScheduleAction.do?s_type=2" id="tag">- 미팅</a></li><br>
	<li style="text-decoration: none;"><a href="TypeScheduleAction.do?s_type=3" id="tag">- 회의</a></li><br>
</ul>

<ol class="breadcrumb">
  <li class="breadcrumb-item"><a href="moveSchedule.do" id="tag">홈</a></li>
  <li class="breadcrumb-item"><a href="insertForm.do" id="tag">일정 생성</a></li>
  <li class="breadcrumb-item active"><a href="listAction.do" id="tag" >전체 조회<a></a></li>
</ol>

<div class="card-header">오늘 일정</div>
<c:forEach var="schedule" items="${schedule }">
<div class="card text-white bg-primary mb-3" style="font-size:10px; width: 200px; height: 100px; position: relative; margin-left: 220px;">
  <div class="card-body">
    <div class="card-title">${schedule.s_title } D+${schedule.remainingdays }</div>
  </div>
 </div>
</c:forEach>


  </body>
</html>