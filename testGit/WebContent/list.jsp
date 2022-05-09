<%@page import="kosta.domain.ScheduleListModel"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<ul class="nav nav-pills flex-column" style="position: absolute;" >
	<li><a href="insertForm.do"><button type="button" class="btn btn-outline-primary">일정 생성</button></a></li><br>
	<li><a href="listAction.do"><button type="button" class="btn btn-outline-primary">일정 조회</button></a></li>

</ul>
    <table class="w3-table w3-striped w3-bordered" style="position: relative; width: 1000px; margin-left: 300px;">
    	<tr>
    		<td>번호
    		<td>제목
    		<td>시작일
    		<td>마감일
    		<td>작성일
    		<td>내용
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
    			<fmt:parseDate var="dt" value="${schedule.s_finishday }" pattern="yyyy-MM-dd"/>
    			<fmt:formatDate value="${dt }" pattern="yyyy-MM-dd"/>	
    		</td>
    		<td>${schedule.s_date }</td>
    		<td>${schedule.s_contents }&nbsp;&nbsp;&nbsp;<input type="checkbox" name="delete"></td>
    	</tr>
    	</c:forEach>
    </table>
    <br>
    

	<div style="margin-left: 700px;">    
	<c:if test="${ScheduleListModel.startPage >= 6 }">
		<a href="listAction.do?pageNum=${ScheduleListModel.startPage-1 }">[이전]</a>
	</c:if>
	
	<c:forEach var="pageNo" begin="${ScheduleListModel.startPage }" end="${ScheduleListModel.endPage }">
		<c:if test="${ScheduleListModel.requestPage == pageNo }"><b></c:if>
			<a href="listAction.do?pageNum=${pageNo }">[${pageNo }]</a>
		<c:if test="${ScheduleListModel.requestPage == pageNo }"></b></c:if>
	</c:forEach>
	<c:if test="${ScheduleListModel.endPage <  ScheduleListModel.totalPage}">
		<a href="listAction.do?pageNum=${ScheduleListModel.endPage + 1 }">[]이후]</a>
	</c:if>
	</div>	
	
	
    
  </body>
</html>