<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.min.css" type = "text/css">

<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.css?ver=4" type = "text/css">

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
          <a class="nav-link" href="logOutAction.do" id = "logout">로그아웃</a>

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
    <a class="nav-link " href="/testGit/board/listNoticeAction.do">공지사항</a>
  </li>
	
  <li class="nav-item">
    <a class="nav-link" href="/testGit/board/listReferenceroomAction.do">자료실</a>
  </li>
	
  <li class="nav-item">
    <a class="nav-link active" href="listReserveAction.do">회의실</a>

  </li>
  
</ul>
<ol class="breadcrumb">

  <li class="breadcrumb-item"><a href="/testGit/Login/mainAction.do">홈</a></li>
  <li class="breadcrumb-item"><a href="listReserveAction.do">회의실</a></li>
</ol>

<div class="container">

    
    <table class="table table-hover">
        
            <tr class="table-dark">
                <th>시작시간</th>
                <td>종료시간</td>
                <td>회의제목</td>
                <th>회의실번호</th>
                <th>예약일자</th>

                <td>예약번호</td>
            </tr>
        
		<c:forEach var="reserve" items="${list }">

		<tr class="table-light">
			<td>${reserve.r_starttime }</td>
			<td>${reserve.r_endtime }</td>
			<td><a href="detailReserveAction.do?r_no=${reserve.r_no }">${reserve.meetingtitle }</a></td>
			<td>${reserve.mr_no }</td>
			<td>${reserve.r_date }</td>

			<%-- <td>${reserve.meetingtitle }</td> --%>
			<td>${reserve.r_no }</td>
		</tr>
		</c:forEach>
    </table>
    
    

    <hr>

    <div style="margin-left: 219px;">
	<a class="badge bg-success"  href="insertMeetingRoomForm.do">회의실1</a>
	<a class="badge bg-success"  href="insertMeetingRoomForm.do">회의실2</a>
	<a class="badge bg-success"  href="insertMeetingRoomForm.do">회의실3</a>
	</div>


	
</div>

</body>
</html>