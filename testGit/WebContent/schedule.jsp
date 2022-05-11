<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
	<li><a href="moveSchedule.do"><button type="button" class="btn btn-outline-primary">홈 </button></a></li><br>
	<li><a href="insertForm.do"><button type="button" class="btn btn-outline-primary">일정 생성</button></a></li><br>
	<li><a href="listAction.do"><button type="button" class="btn btn-outline-primary">전체 조회</button></a></li>
	<hr style="border: solid 1px gray;">
	<li>분류별 일정</li><br>
	<li style="text-decoration: none;"><a href="TypeScheduleAction.do?s_type=1">- 개인</a></li><br>
	<li style="text-decoration: none;"><a href="TypeScheduleAction.do?s_type=2">- 미팅</a></li><br>
	<li style="text-decoration: none;"><a href="TypeScheduleAction.do?s_type=3">- 회의</a></li><br>
</ul>

 <table class="w3-table w3-striped w3-bordered" style="position: relative; width: 1000px; margin-left: 300px;">
    	<tr>
    		<td>번호
    		<td>제목
    		<td>시작일
    		<td>마감일
    		<td>남은 기간
    		<td>상태
    	</tr>
    	<c:forEach var="schedule" items="${ScheduleListModel.list }">
    	<tr>
    		<td><a href="scheduleDetailAction.do?s_no=${schedule.s_no}">${schedule.s_no }</a></td>
    		<td>${schedule.s_title }</td>
    		
    		<td>
    			<fmt:parseDate var="dt" value="${schedule.s_startday }" pattern="yyyy-MM-dd"/>
    			<fmt:formatDate value="${dt }" pattern="yyyy-MM-dd"/>
    		</td>
    		<td>
    			~<fmt:parseDate var="dt" value="${schedule.s_finishday }" pattern="yyyy-MM-dd"/>
    			<fmt:formatDate value="${dt }" pattern="yyyy-MM-dd"/>	
    		</td>
    		<td>D+${schedule.remainingdays }</td>
    		<td>${schedule.situation }&nbsp;&nbsp;&nbsp;</td>
    	</tr>
    	</c:forEach>
    </table>
    <br>
    
<div style="margin-left: 750px;">    
	<c:if test="${ScheduleListModel.startPage >= 6 }">
		<a href="SchedulePageAction.do?pageNum=${ScheduleListModel.startPage-1 }">[이전]</a>
	</c:if>
	
	<c:forEach var="pageNo" begin="${ScheduleListModel.startPage }" end="${ScheduleListModel.endPage }">
		<c:if test="${ScheduleListModel.requestPage == pageNo }"><b></c:if>
			<a href="SchedulePageAction.do?pageNum=${pageNo }">[${pageNo }]</a>
		<c:if test="${ScheduleListModel.requestPage == pageNo }"></b></c:if>
	</c:forEach>
	<c:if test="${ScheduleListModel.endPage <  ScheduleListModel.totalPage}">
		<a href="SchedulePageAction.do?pageNum=${ScheduleListModel.endPage + 1 }">[]이후]</a>
	</c:if>
	</div>	

        <c:if test="${ScheduleListModel.endPage < ScheduleListModel.totalPage}">
            <li class="page-item">
                <a class="page-link" href="SchedulePageAction.do?pageNum=${ScheduleListModel.endPage + 1}">&raquo;</a>
            </li>
        </c:if>
  

    <br>

  </body>
</html>