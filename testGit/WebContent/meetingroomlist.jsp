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
    <a class="nav-link active" href="/TestGit/board/listNoticeAction.do">공지사항</a>
  </li>
	
  <li class="nav-item">
    <a class="nav-link" href="/TestGit/board/listReferenceroomAction.do">자료실</a>
  </li>
	
  <li class="nav-item">
    <a class="nav-link" href="listReserveAction.do">회의실</a>
  </li>
  
</ul>
<ol class="breadcrumb">
  <li class="breadcrumb-item"><a href="#">Home</a></li>
  <li class="breadcrumb-item"><a href="#">Library</a></li>
  <li class="breadcrumb-item active">Data</li>
</ol>

<div class="container">
    <br>
    <h1 class="text-center"><a>회의실</a></h1>
    <br>
    <br>
    
    <table class="table table-hover table-striped text-center" style="border: 1px solid;">
        
            <tr>
                <th>회의실번호</th>
                <th>예약일자</th>
                <th>시작시간</th>
                <td>종료시간</td>
                <td>회의제목</td>
                <td>예약번호</td>
            </tr>
        
		<c:forEach var="reserve" items="${list }">
		<tr>
			<td>${reserve.mr_no }</td>
			<td>${reserve.r_date }</td>
			<td>${reserve.r_starttime }</td>
			<td>${reserve.r_endtime }</td>
			<td><a href="detailReserveAction.do?r_no=${reserve.r_no }">${reserve.meetingtitle }</a></td>
			<%-- <td>${reserve.meetingtitle }</td> --%>
			<td>${reserve.r_no }</td>
		</tr>
		</c:forEach>
    </table>
    
    

    <hr>

    <a class="btn btn-outline-info float-right" href="insertMeetingRoomForm.do">회의실1</a>
    <a class="btn btn-outline-info float-right" href="insertMeetingRoomForm.do">회의실2</a>
    <a class="btn btn-outline-info float-right" href="insertMeetingRoomForm.do">회의실3</a>
	
</div>

</body>
</html>