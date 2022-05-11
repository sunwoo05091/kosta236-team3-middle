<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/schedule.css" type="text/css">
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
 }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel = "stylesheet" href="Resource/CSS/bootstrap.min.css" type = "text/css">
<link rel = "stylesheet" href="Resource/CSS/bootstrap.css" type = "text/css">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.min.css" type = "text/css">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.css" type = "text/css">
<link rel = "stylesheet" href="Resource/CSS/insertForm.css" type="text/css">
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
<ul class="nav nav-pills flex-column" style="position: absolute;">
	<div class="card bg-light mb-3" style="max-width: 20rem;">
		  <div class="card-body">
		    <svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="100%" height="130" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size:1.125rem;text-anchor:middle">
    			<rect width="100%" height="100%" fill="#868e96"></rect>
    			<text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
  			</svg>
  			<br>
		    <div class="card-text"><div>인사 부서</div><div>${emp.grade } ${emp.name }님</div></div>
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
<div id="header" style="border: 1px solid;width: 700px; height: 500px;margin-left: 450px; margin-top: 50px;
padding-left: 10px;padding-top: 30px">
<form action="insertAction.do" method="post">
	<input type="submit" value="저장" class="submit" style="margin-left: 600px; margin-bottom: 200px; position: absolute;">
	제목 : <input type="text" name="s_title" id="a"><br><br>
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
	<br><br>
	<textarea rows="10" cols="70" name="s_contents" id="text"></textarea><br>
</form>
</div>

</body>
</html>