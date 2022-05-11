<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<style type="text/css">
	.form-group{
		margin-left: 300px;
		width: 600px;
	}
	h3{
		margin-left: 550px;
	}
</style>
</head>
<body>
<h3>글쓰기</h3>
<hr>
<!-- <form action="insertMeetingRoomAction.do" method="post"> 	
	회의실번호 : <input type="text" name="mr_no"><br>		
	예약일자 : <input type="text" name="r_date"><br>		
	시작시간 : <input type="text" name="r_starttime"><br>		
	종료시간 : <input type="text" name="r_endtime"><br>		
	회의제목 : <input type="text" name="meetingtitle"><br>					
	<br>
	<input type="submit" value="등록">
</form> -->

<form action="insertMeetingRoomAction.do" method="post">
   
    <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">회의실번호</label>
      <input type="text" name="mr_no" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="회의실번호를 입력하세요">    
    </div>

    <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">예약일자</label>
      <input type="text" name="r_date" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="예약일자를 입력하세요">    
    </div>
    
    <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">시작시간</label>
      <input type="text" name="r_starttime" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="시작시간을 입력하세요">    
    </div>
    
    <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">종료시간</label>
      <input type="text" name="r_endtime" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="종료시간을 입력하세요">    
    </div>
    
    <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">회의제목</label>
      <input type="text" name="meetingtitle" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="회의제목을 입력하세요">    
    </div>


    <input class="btn btn-outline-success" type="submit" value="등록" style="margin-left: 620px; margin-top: 20px; size: 100px;">
    
</form>

</body>
</html>