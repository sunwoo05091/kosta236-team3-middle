<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.css?ver=6" type = "text/css">
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
          <a class="nav-link" href="/testGit/board/listNoticeAction.do">공지사항</a>
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
	<li>
	<div class="card bg-light mb-3" style="max-width: 20rem;">
	    	<div  style="border:1px solid #dedede; width:100%; height:60px; line-height:50px; color:#666;font-size:50px; text-align:center;" id="clock">
			</div>
			<div class="btn-group" role="group" aria-label="Basic example">
			  <button type="button" class="btn btn-secondary" id="workcheckbtn" onclick="location.href='checkInAction.do?e_no=${emp.e_no }'">출근</button>
			  <button type="button" class="btn btn-secondary" id="workcheckbtn">외근</button>
			  <button type="button" class="btn btn-secondary" id="workcheckbtn" onclick="location.href='checkOutAction.do?e_no=${emp.e_no }'">퇴근</button>
			</div>
	</div>
	</li>
	<li class="nav-item">
    	<a class="nav-link" href="organizationChartAction.do">조직도</a>
  </li>
</ul>
<div>
<ul class="mainCard">
	<li class="mainbox">
<div class="card bg-light mb-3" style="max-width: 20rem;">
  <div class="card-header"><img src="/testGit/upload/document.PNG">전자결제</div>
  <div class="card-body">
  <ul>
	  <li>
   	 	<a class="card-text" href="/testGit/document/insertForm.do">문서작성</a>
 	 </li>
	  <li>
   	 	<a class="card-text" href="#">수신함</a>
 	 </li>
	  <li>
   	 	<a class="card-text" href="/testGit/document/listDocumentSignCompleteAction.do"> 완료문서함</a>
 	 </li>
  </ul>
  </div>
</div>
	</li>
	<li class="mainbox">
<div class="card bg-light mb-3" style="max-width: 20rem;">
  <div class="card-header"><img src="/testGit/upload/calendar.PNG">일정관리</div>
  <div class="card-body">
  <ul>
	  <li>
   	 	<a class="card-text" href="/testGit/schedule/moveSchedule.do">일정관리</a>
 	 </li>
	  <li>
   	 	<a class="card-text" href="/testGit/schedule/insertForm.do">일정작성</a>
 	 </li>
	  <li>
   	 	<a class="card-text" href="/testGit/schedule/listAction.do">일정 전체조회</a>
 	 </li>
  </ul>
  </div>
</div>
	</li>
	<li class="mainbox">
<div class="card bg-light mb-3" style="max-width: 20rem;">
  <div class="card-header"><img src="/testGit/upload/board.PNG">공지사항</div>
  <div class="card-body">
  <ul>
	  <li>
   	 	<a class="card-text" href="/testGit/board/listNoticeAction.do">공지사항</a>
 	 </li>
	  <li>
   	 	<a class="card-text" href="/testGit/board/listReferenceroomAction.do">자료실</a>
 	 </li>
	  <li>
   	 	<a class="card-text" href="/testGit/Meetingroom/listReserveAction.do">회의실</a>
 	 </li>
  </ul>
  </div>
</div>
	</li>
</ul>
</div>
<div>
<ul class="mainCard">
	<li class="mainbox">
<div class="card bg-light mb-3" style="max-width: 20rem;">
  <div class="card-header"><img src="/testGit/upload/community.PNG">커뮤니티</div>
  <div class="card-body">
  <ul>
	  <li>
   	 	<a class="card-text" href="/testGit/community/listCommunityAction.do">중고거래게시판</a>
 	 </li>
	  <li>
   	 	<a class="card-text" href="/testGit/community/listCommunityClubAction.do">동아리게시판</a>
 	 </li>
	  <li>
   	 	<a class="card-text" href="/testGit/community/listCommunityCarfullAction.do">카풀게시판</a>
 	 </li>
  </ul>
  </div>
</div>
	</li>
	<li class="mainbox">
<div class="card bg-light mb-3" style="max-width: 20rem;">
  <div class="card-header"><img src="/testGit/upload/mypage.PNG">마이페이지</div>
  <div class="card-body">
  <ul>
	  <li>
   	 	<a class="card-text" href="#"> 문서관리</a>
 	 </li>
	  <li>
   	 	<a class="card-text" href="#"> 문서관리</a>
 	 </li>
	  <li>
   	 	<a class="card-text" href="#"> 문서관리</a>
 	 </li>
  </ul>
  </div>
</div>
	</li>
	<c:if test = "${emp.d_no == 1}">
	<li class="mainbox">
<div class="card bg-light mb-3" style="max-width: 20rem;">
  <div class="card-header"><img src="/testGit/upload/personel.PNG">인사관리</div>
  <div class="card-body">
  <ul>
	  <li>
   	 	<a class="card-text" href="listSignUpApproveAction.do"> 계정신청승인</a>
 	 </li>
	  <li>
   	 	<a class="card-text" href="#"> 문서관리</a>
 	 </li>
	  <li>
   	 	<a class="card-text" href="#"> 문서관리</a>
 	 </li>
  </ul>
  </div>
</div>
	</li>
	</c:if>
</ul>
</div>
</body>
</html>