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
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/schedule.css" type="text/css">
<style type="text/css">
   .pageBox{
      width: 700px;
      margin-left: 430px;
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

 <table class="table table-hover" style="position: relative; width: 1000px; margin-left: 300px;">
    	<tr class="table-dark">
    		<td>??????
    		<td>??????
    		<td>?????????
    		<td>?????????
    		<td>?????? ??????
    		<td>??????
    	</tr>
    	<c:forEach var="schedule" items="${ScheduleListModel.list }">
    	<tr class="table-light">
    		<td><a href="scheduleDetailAction.do?s_no=${schedule.s_no}" style="text-decoration: none;">${schedule.s_no }</a></td>
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
<div class="pageBox">
 <ul  class="pagination">
		<c:if test="${ScheduleListModel.startPage >= 6 }">
	<li class="page-item active">
		<a href="SchedulePageAction.do?pageNum=${ScheduleListModel.startPage-1 }"class="page-link">??????</a>
	</li>
	</c:if>
	
	<c:forEach var="pageNo" begin="${ScheduleListModel.startPage }" end="${ScheduleListModel.endPage }">
		<c:if test="${ScheduleListModel.requestPage == pageNo }"><b></c:if>
		<li class="page-item active">
			<a href="SchedulePageAction.do?pageNum=${pageNo }" style="text-decoration: none;">${pageNo }&nbsp&nbsp</a>
		</li>
		<c:if test="${ScheduleListModel.requestPage == pageNo }"></b></c:if>
	</c:forEach>
	<c:if test="${ScheduleListModel.endPage <  ScheduleListModel.totalPage}">
	<li class="page-item active">	
		<a href="SchedulePageAction.do?pageNum=${ScheduleListModel.endPage + 1 }">??????</a>
	</li>
	</c:if>
        <c:if test="${ScheduleListModel.endPage < ScheduleListModel.totalPage}">
            <li class="page-item">
                <a class="page-link" href="SchedulePageAction.do?pageNum=${ScheduleListModel.endPage + 1}">&raquo;</a>
            </li>
        </c:if>
       </ul>
      </div>
    <br>
  </body>
</html>