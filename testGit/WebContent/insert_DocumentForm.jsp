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
<script type="text/javascript" src="${pageContext.request.contextPath}/Resource/js/login.js?ver=1"></script>
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.min.css" type = "text/css">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.css?ver=4" type = "text/css">
</head>
<body onload = "printClock()">
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">StarWorks</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link active" href="/testGit/Login/mainAction.do">홈
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
<li>
      <div class="card bg-light mb-3" style="max-width: 20rem;">
        <div class="card-body">
          <svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="100%" height="130" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size:1.125rem;text-anchor:middle">
             <rect width="100%" height="100%" fill="#868e96"></rect>
             <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
           </svg>
           <br>
          <div class="card-text"><div>${d_name }부서</div><div>${emp.grade } ${emp.name }님</div></div>
        </div>
      </div>
   </li>
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
  <li class="breadcrumb-item"><a href="/testGit/Login/mainAction.do">메인페이지</a></li>
</ol>

<form action="insertAction.do" method="post" enctype="multipart/form-data">
<div class="control-group" style="width: 1200px; height: 300px; margin: auto;">
    <label class="control-label" ></label>
    <div class="controls">
    사원번호 : <input type="text" class="form-control" name="e_no" placeholder="사원번호 입력"><br>
    문서상태 :  <select input type="text" class="form-select"  name="dc_state" ><br>
        <option>결재 진행</option>
      </select><br>
      
    결재선 : <input type="text"  class="form-control" placeholder="결재선 입력"><br>
    <input type="button" value="결재선 추가" onclick="window.open('URL', '_blank', 'width=730, height=750, toolbar=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no' );">
     <input type="button" value="결재선 삭제" onclick=history.back()><br><br>
    
    참조자 : <input type="text"  class="form-control" placeholder="결재선 입력"><br>
   	<input type="button" value="참조자 추가" onclick="window.open('URL', '_blank', 'width=730, height=750, toolbar=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no' );">
    <input type="button" value="참조자 삭제" onclick=history.back()><br><br>
    
    수신자 : <input type="text"  class="form-control" placeholder="결재선 입력"><br>
    <input type="button" value="수신자 추가" onclick="window.open('URL', '_blank', 'width=730, height=750, toolbar=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no' );">
    <input type="button" value="수신자 삭제" onclick=history.back()><br><br>
    
	제목 : <input type="text"  class="form-control" name="dc_title" placeholder="제목 입력"><br>
	내용 : <textarea class="form-control" input type="text" name="dc_contents" rows="3" placeholder="내용 입력"></textarea><br>
	첨부파일 : <for="formFile" class="form-label mt-4">
     		<input class="form-control" input type="file" name="dc_fname"><br>
     
	<input type="submit" class="btn" value="확인">
	<a class="btn" href="#" onclick=history.back()>취소</a>
	<input type="reset" class="btn" value="초기화">
    </div>
  </div>
</form>



</body>
</html>