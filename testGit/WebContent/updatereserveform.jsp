<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글수정폼</h3>
	<form action= "updateReserveAction.do" method="post">
		<input type="hidden" name="r_no" value="${reserve.r_no}"> 
<%-- 		예약일자: ${reserve.r_date}<br>
		시작시간: ${reserve.r_starttime}<br>
		종료시간: ${reserve.r_endtime}<br> --%>
		회의제목 : <input type="text" name="meetingtitle" value="${reserve.meetingtitle}"><br>
		시작시간 : <input type="text" name="r_starttime" value="${reserve.r_starttime}"><br>
		종료시간 : <input type="text" name="r_endtime" value="${reserve.r_endtime}"><br>
		예약일자 : <input type="text" name="r_date" value="${reserve.r_date}"><br>
		
		<input type="submit" value="수정완료">
	</form>
</body>
</html>