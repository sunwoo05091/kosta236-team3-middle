<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel = "stylesheet" href="Resource/CSS/bootstrap.min.css" type = "text/css">
<link rel = "stylesheet" href="Resource/CSS/bootstrap.css" type = "text/css">
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
  <li class="breadcrumb-item"><a href="#">메인페이지</a></li>
</ol>

<div style="width: 1200px; height: 300px; margin: auto;">
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">문서번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">부서</th>    
      <th scope="col">작성일</th>  
      <th scope="col">문서상태</th>  
    </tr>
  </thead>
  <tbody>

		<c:forEach var="document" items="${documentList.list }">
		<tr>
			<td><a href="detailAction.do?dc_no=${document.dc_no }">${document.dc_no }</a></td>
		    <td>${document.dc_title }</td>
		    <td>${document.grade }  ${document.name }</td>
		    <td>${document.d_name }</td>
		    <td>
				<fmt:parseDate var="dt" value="${document.dc_date }" pattern="yyyy-MM-dd HH:mm:ss"/>
				<fmt:formatDate value="${dt }" pattern="yyyy/MM/dd"/>
			</td>
		    <td>${document.dc_state }</td>
		</c:forEach>
  </tbody>
</table>

	<!-- 페이징 처리 -->
	<div>
  <ul class="pagination">
    <li class="page-item disabled">
	<c:if test="${documentList.startPage >= 6 }">
	    <li class="page-item">
		<a class="page-link" href="listDocumentSignCompleteAction.do?pageNum=${documentList.startPage - 1 }">[이전]</a>
		</li>
	</c:if>
	
	<c:forEach var="pageNo" begin="${documentList.startPage }" end="${documentList.endPage }">
		<c:if test="${documentList.requestPage == pageNo }"></c:if>
		<li class="page-item">
		<a class="page-link" href="listDocumentSignCompleteAction.do?pageNum=${pageNo }">[${pageNo }]</a>
		</li>
		<c:if test="${documentList.requestPage == pageNo }"></c:if>
	</c:forEach>
	
	<c:if test="${documentList.endPage < documentList.totalPageCount }">
		 <li class="page-item">
		<a class="page-link" href="listDocumentSignCompleteAction.do?pageNum=${documentList.endPage + 1 }">[이후]</a>
		</li>
	</c:if>
	</li>
	</ul>
	</div>

<form action="listDocumentSignCompleteAction.do" method="get">
	<input class="form-check-input" type="checkbox" name="area" value="dc_no">문서번호
	<input class="form-check-input" type="checkbox" name="area" value="dc_title">제목
	<input class="form-check-input" type="checkbox" name="area" value="name">작성자
	
	<div class="form-group">
	<div class="input-group mb-3" style="width: 500px; height: 50px;">
	<input type="text" class="form-control" name="searchKey" placeholder="검색어를 입력" aria-describedby="button-addon2">
	<button type="submit" class="btn">검색</button>
	</div>
	</div>
	
</form>
</div>

</body>
</html>