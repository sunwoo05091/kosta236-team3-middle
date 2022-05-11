<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<style type="text/css">
#a {
  width: 500px;
  height: 32px;
  font-size: 15px;
  border: 0;
  border-radius: 15px;
  outline: none;
  padding-left: 10px;
  background-color: rgb(233, 233, 233);
}
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
 #text{
  resize: none;
  border: none;
  margin-left: 35px;
  margin-top: 15px;
}
</style>
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
          <a class="nav-link active" href="mainAction.do">홈
            <span class="visually-hidden">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/testGit/document/listAction.do">전자결제</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/testGit/schedule/moveSchedule.do">일정관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/testGit/Meetingroom/listNoticeAction.do">공지사항</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/testGit/community/listCommunityAction.do">커뮤니티</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">마이페이지</a>
        </li>
      </ul>
      <form class="d-flex">
          <a class="nav-link" href="/testGit/Login/logOutAction.do" id = "logout">로그아웃</a>
      </form>
    </div>
  </div>
</nav>
 <ul class="nav nav-pills flex-column">
 	<li><a href="moveSchedule.do"><button type="button" class="btn btn-outline-primary">홈 </button></a></li><br>
	<li><a href="insertForm.do"><button type="button" class="btn btn-outline-primary">일정 생성</button></a></li><br>
	<li><a href="listAction.do"><button type="button" class="btn btn-outline-primary">일정 조회</button></a></li>
</ul>
<div id="header" style="border: 1px solid;width: 700px; height: 500px;margin-left: 450px; margin-top: 50px;
padding-left: 10px;padding-top: 30px">
<form action="updateAction.do" method="post">
<input type="submit" value="저장" class="submit" style="margin-left: 600px; margin-bottom: 200px; position: absolute;">
<input type="hidden" name="s_no" value="${schedule.s_no }">
	제목 : <input type="text" name="s_title" value="${schedule.s_title }"style="margin-left: 10px; margin-bottom: 200px; position: absolute;"><br><br>
	기간 : <input type="date" name="s_startday" style=" border-radius: 10px; border-color:#d2d2d2;"> ~ <input type="date" name="s_finishday" style=" border-radius: 10px;border-color:#d2d2d2;">
	진행 : <select name="situation">
			<option>선택</option>
			<option value="진행">진행중
			</option>
			<option value="완료">완료</option>
			<option value="보류">보류</option>	
		 </select>
	종류 : <select name="s_type">
			<option>선택</option>
			<option value="개인">개인
			</option>
			<option value="미팅">미팅</option>
			<option value="회의">회의</option>	
		 </select>
	<textarea rows="10" cols="70" name="s_contents" id="text">${schedule.s_contents }</textarea><br>
</form>
</div>
</body>
</html>
