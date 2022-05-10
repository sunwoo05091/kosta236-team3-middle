<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글세부보기</h2>
	<ul>
		<li>${reserve.r_no }</li>
		<li>${reserve.meetingtitle }</li>
		<li>${reserve.r_starttime }</li>
		<li>${reserve.r_endtime }</li>
		<li>${reserve.mr_no }</li>
	</ul>
	<br>
	
	<a href="updateReserveForm.do?r_no=${reserve.r_no }">글수정</a>
	<a href="deleteReserveAction.do?r_no=${reserve.r_no }">삭제</a>
</body>
</html>