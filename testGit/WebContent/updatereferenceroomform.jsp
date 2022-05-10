<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>글수정폼</h3>
	<form action= "updateReferenceroomAction.do" method="post">
		<input type="hidden" name="b_no" value="${board.b_no}"> 
		사원번호: ${board.e_no}<br>
		제목 : <input type="text" name="b_title" value="${board.b_title}"><br>
		내용 : <br>
		<textarea rows="6" cols="70"name="b_contents">${board.b_contents}</textarea>
		<input type="submit" value="수정완료">
	</form>
</body>
</html>