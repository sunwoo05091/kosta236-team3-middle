<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>calendar</title>
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/schedule.css" type="text/css">
<style type="text/css">
 input[type=submit] {
            background-color:#FF5A5F;
            color:white;
            width: 70px;
            height: 45px;
            font-size: 15px;
            font-weight: 700;
            border-radius: 6px;
            border: 0;
            outline: 0;
 }
  #header{
  border: 1px solid #d2d2d2; 
  background-color: #d2d2d2; 
  border-radius: 16px;
  box-shadow: inset 0 0 8px #d2d2d2;
  width: 160px; height: 160px;
 }
</style>
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

</head>
<body background="ECF1F8">
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">StarWorks</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link active" href="mainAction.do">???
            <span class="visually-hidden">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/testGit/document/listAction.do">????????????</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/testGit/schedule/moveSchedule.do">????????????</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/testGit/Meetingroom/listNoticeAction.do">????????????</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/testGit/community/listCommunityAction.do">????????????</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">???????????????</a>
        </li>
      </ul>
      <form class="d-flex">
          <a class="nav-link" href="/testGit/Login/logOutAction.do" id = "logout">????????????</a>
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
		    <div class="card-text"><div>?????? ??????</div><div>${emp.grade } ${emp.name }???</div></div>
		  </div>
	</div>
  <li class="nav-item">
    <a class="nav-link active" href="moveSchedule.do">?????? ??????</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="insertForm.do">?????? ??????</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="listAction.do">?????? ??????</a>
  </li>
  <hr style="border: solid 1px gray;">
	<li>????????? ??????</li><br>
	<li style="text-decoration: none;"><a href="TypeScheduleAction.do?s_type=1" id="tag">- ??????</a></li><br>
	<li style="text-decoration: none;"><a href="TypeScheduleAction.do?s_type=2" id="tag">- ??????</a></li><br>
	<li style="text-decoration: none;"><a href="TypeScheduleAction.do?s_type=3" id="tag">- ??????</a></li><br>
</ul>

<ol class="breadcrumb">
  <li class="breadcrumb-item"><a href="moveSchedule.do" id="tag">???</a></li>
  <li class="breadcrumb-item"><a href="insertForm.do" id="tag">?????? ??????</a></li>
  <li class="breadcrumb-item active"><a href="listAction.do" id="tag" >?????? ??????<a></a></li>
</ol>
<div id="header" style="border: 1px solid;width: 700px; height: 500px;margin-left: 450px; margin-top: 50px;
padding-left: 10px;padding-top: 30px">
			?????? : ${schedule.s_title }<br><br>
			<div>?????? : ${schedule.s_startday } ~ ${schedule.s_finishday }</div>
			<hr style="border: solid 1px gray;">
			<div>${schedule.s_contents }</div>
</div>
<br>
<a href="moveUpdateScheduleAction.do?s_no=${schedule.s_no }"><input type="submit" value="??????" style="margin-left: 925px; position: absolute;"></a>
<a href="deleteScheduleAction.do?s_no=${schedule.s_no }"><input type="submit" value="??????" style="margin-left: 1000px; position: relative;"></a>
</body>
</html>