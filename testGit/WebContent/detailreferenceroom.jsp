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
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.css" type = "text/css">
<style type="text/css">
	
.ContentBox{
		border:  solid 2px;
		border-radius: 10px;
		width: 1100px;
		height: 1500px;
		margin-left: 500px;
		background-color: white;
		
	}
	
	.detail_box{
		margin-left: 20px;
		margin-top: 50px;
	}
	
	.bottom_box{
		margin-top: 30px;
        margin-left: 950px;  
   }
   
   .b_title{
      font-size: 30px;
      color : black;
   }
   
   img{
   	width: 1000px;
   	margin-left: 50px;
   	margin-top: 30px;
   }
   
   a{
   	text-decoration: none;
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
          <a class="nav-link active" href="/testGit/Login/mainAction.do">???
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
          <a class="nav-link" href="logOutAction.do" id = "logout">????????????</a>
      </form>
    </div>
  </div>
</nav>
<ul class="nav nav-pills flex-column">
  <li class="nav-item">
    <a class="nav-link " href="listNoticeAction.do">????????????</a>
  </li>
	
  <li class="nav-item">
    <a class="nav-link active" href="listReferenceroomAction.do">?????????</a>
  </li>
	
  <li class="nav-item">
    <a class="nav-link" href="/testGit/Meetingroom/listReserveAction.do">?????????</a>
  </li>
  
</ul>
<ol class="breadcrumb">
  <li class="breadcrumb-item"><a href="/testGit/Login/mainAction.do">???</a></li>
  <li class="breadcrumb-item"><a href="listReferenceroomAction.do">?????????</a></li>
</ol>

<div class="ContentBox">

	<div class="bottom_box">
		<a class="badge bg-success" href="updateReferenceroomForm.do?b_no=${board.b_no }">?????????</a>
		<a class="badge bg-warning" href="deleteReferenceroomAction.do?b_no=${board.b_no }">??????</a>
	</div>
		
			<c:if test="${board.b_fname != null }">
				<c:set var="head" value="${fn:substring(board.b_fname, 
										0, fn:length(board.b_fname)-4) }"></c:set>
				<c:set var="pattern" value="${fn:substring(board.b_fname, 
				fn:length(head) +1, fn:length(board.b_fname)) }"></c:set>
					
				<c:choose>
					<c:when test="${pattern == 'jpg' || pattern == 'gif' || pattern =='png' }">
						<img src="/testGit/upload/${head }.${pattern}">
					</c:when>
					<c:otherwise>
						<c:out value="NO IMAGE"></c:out>
					</c:otherwise>
				</c:choose>
			</c:if>
		<br>
		
	<div class="detail_box">
		<p class="b_title">${board.b_title }</p>
		<p>${board.b_date }</p><br>
		<p class="b_contents">${board.b_contents }</p>
	</div>
</div>


</body>
</html>