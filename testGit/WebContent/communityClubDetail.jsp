<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.min.css" type = "text/css">
<link rel = "stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.css" type = "text/css">
<link rel = "stylesheet" href="Resource/CSS/bootstrap.min.css" type = "text/css">
<link rel = "stylesheet" href="Resource/CSS/bootstrap.css" type = "text/css">
<link rel = "stylesheet" href="Resource/CSS/Community.css" type = "css/style.css">
<style type="text/css">
	textarea{
		height: 100px;
		width: 800px;
		border-radius: 10px;
		border: solid 2px;
	}
	
	.ContentBox{
		border:  solid 2px;
		border-radius: 10px;
		width: 1100px;
		height: 1500px;
		margin-left: 500px;
		background-color: white;
		
	}
	
	img{
		width: 1000px;
		
		margin-left: 50px;
	}
	
	.detail_box{
		margin-left: 100px;
	}
	
	.reply_box{
		width: 1200px;
		margin-top: 100px;
		margin-left: 100px;
		color : black;
	}
	
	.bottom_box{
	}
	
	p{
		display: inline;
	}
	
	.cm_title{
		font-size: 30px;
		color : black;
	}
	
	.cm_price{
		font-size: 20px;
		color : black;
		 
	}
	
	.cm_contents{
		color : black;
	}
	
	.cm_state{
		font-size: 30px;
		color : #fb6400;
	}
</style>
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
<ul class="nav nav-pills flex-column">
  <li class="nav-item">
    <a class="nav-link " href="listCommunityAction.do">중고거래게시판</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="listCommunityClubAction.do">동아리게시판</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="listCommunityCarfullAction.do">카풀게시판</a>
  </li>
  
</ul>
<ol class="breadcrumb">
  <li class="breadcrumb-item"><a href="#">Home</a></li>
  <li class="breadcrumb-item"><a href="#">Library</a></li>
  <li class="breadcrumb-item active">Data</li>
</ol>
	<h2>글세부보기</h2>
	
	
	<div class="ContentBox">
		<h3>${community.cm_title }</h3>
			<c:if test="${community.cm_fname != null }">
				<c:set var="head" value="${fn:substring(community.cm_fname, 
										0, fn:length(community.cm_fname)-4) }"></c:set>
				<c:set var="pattern" value="${fn:substring(community.cm_fname, 
				fn:length(head) +1, fn:length(community.cm_fname)) }"></c:set>
					
				<c:choose>
					<c:when test="${pattern == 'jpg' || pattern == 'gif' || pattern =='png' }">
						<img src="/testGit/upload/${head }.${pattern}">
					</c:when>
					<c:otherwise>
						<c:out value="NO IMAGE"></c:out>
					</c:otherwise>
				</c:choose>
			</c:if>
			
		<div class="detail_box">
			<p class="cm_state">${community.cm_state }</p><span class="cm_title"> ${community.cm_title }</span><br>
			<p>${community.cm_date }</p><br>
			<p class="cm_contents">${community.cm_contents }</p>
		</div>
	
	
	<div class="reply_box">
	
		<h5>댓글목록</h5>
		<c:forEach var="reply" items="${replys }">
			<ul>
				<li>${reply.cm_r_contents }</li>
				<li>${reply.cm_r_date }</li>
			</ul>
		</c:forEach>
		
		
		<form action="insertReplyAction.do" method="post">
			<input type="hidden" name="cm_no" value="${community.cm_no }">
			<textarea class="textarea" name="cm_r_contents">
			</textarea><br>
			<input class="btn btn-outline-success" type="submit" value="댓글쓰기" style="margin-left: 700px; "> 
		</form>
		
	
	</div>
	
	
	<div class="bottom_box">
		<a href="updateClubForm.do?cm_no=${community.cm_no}">글수정</a>
		<a href="deleteTrade.do?cm_no=${community.cm_no}">글삭제</a>
	</div>
	</div>
</body>
</html>