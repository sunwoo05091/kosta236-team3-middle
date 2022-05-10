<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글쓰기</h3>
<hr>
<form action="insertMeetingRoomAction.do" method="post"> 	
	회의실번호 : <input type="text" name="mr_no"><br>		
	예약일자 : <input type="text" name="r_date"><br>		
	시작시간 : <input type="text" name="r_starttime"><br>		
	종료시간 : <input type="text" name="r_endtime"><br>		
	회의제목 : <input type="text" name="meetingtitle"><br>					
	<br>
	<input type="submit" value="등록">
</form>
</body>
</html>