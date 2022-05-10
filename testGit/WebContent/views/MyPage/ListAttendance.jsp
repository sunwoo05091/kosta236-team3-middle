<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JKM
  Date: 2022-05-04
  Time: 오전 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/Resource/CSS/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/Resource/CSS/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="/Resource/CSS/bootstrap_modify.css" type="text/css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01"
                aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
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
                    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                       aria-haspopup="true" aria-expanded="false">Dropdown</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another kosta.action</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Separated link</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>

<ul class="nav nav-pills flex-column">
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/private-info">개인 정보</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="${sessionScope.contextPath}/mypage/attendance">근태 기록</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/annual-leave">연차 기록</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/paystub">급여 명세서</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/phonebook">주소록</a>
    </li>
</ul>

<ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="${sessionScope.contextPath}/mypage/attendance">근태 기록</a></li>
</ol>

<ul>
    <table class="table table-hover">
        <thead>
        <tr class="table-dark">
            <td>사원 번호</td>
            <td>날 짜</td>
            <td>출근 시간</td>
            <td>퇴근 시간</td>
        </tr>
        </thead>
        <tbody>
        <c:set var="odd" value="true"/>
        <c:forEach var="Attendance" items="${listAttendance.list}">
            <c:choose>
                <c:when test="${odd eq true}">
                    <tr class="table-info">
                    <c:set var="odd" value="false"/>
                </c:when>
                <c:when test="${odd eq false}">
                    <tr class="table-secondary">
                    <c:set var="odd" value="true"/>
                </c:when>
            </c:choose>
            <td>${Attendance.e_No}</td>
            <td>${Attendance.a_Date}</td>
            <td>${Attendance.a_CheckIn}</td>
            <td>${Attendance.a_CheckOut}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</ul>
<div>
    <ul class="pagination">
        <c:if test="${listAttendance.startPage >= 6}">
            <li class="page-item disabled">
                <a class="page-link" href="attendance?pageNum=${listAttendance.startPage - 1}">&laquo;</a>
            </li>
        </c:if>

        <c:forEach var="pageNo" begin="${listAttendance.startPage}" end="${listAttendance.endPage}">
            <c:choose>
                <c:when test="${listAttendance.requestPage == pageNo}">
                    <li class="page-item active">
                        <a class="page-link" href="attendance?pageNum=${pageNo}">${pageNo}</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="attendance?pageNum=${pageNo}">${pageNo}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${listAttendance.endPage < listAttendance.totalPageCount}">
            <li class="page-item">
                <a class="page-link" href="attendance?pageNum=${listAttendance.endPage + 1}">&raquo;</a>
            </li>
        </c:if>
    </ul>
</div>
</body>
</html>
