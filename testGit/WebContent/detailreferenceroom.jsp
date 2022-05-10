<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>글세부보기</h2>
	<ul>
		<li>${board.b_no }</li>
		<li>${board.b_title }</li>
		<li>${board.e_no }</li>
		<li>${board.b_contents }</li>
		<li><a href="/testGit/downloadboard.jsp?filename=${board.b_fname}">${board.b_fname}</a></li>
	</ul>
	<br>
	
	<a href="updateReferenceroomForm.do?b_no=${board.b_no }">글수정</a>
	<a href="deleteReferenceroomAction.do?b_no=${board.b_no }">삭제</a>
</body>
</html>