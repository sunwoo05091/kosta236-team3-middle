Created by IntelliJ IDEA.
User: JKM
Date: 2022-04-28
Time: 오후 2:26
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  //테스트 부분
  String testId = "testId";
  session.setAttribute("userId", testId);


%>

<html>
<head>
  <title>MainPage</title>

  <script>
    <%--GET 방식--%>
    location.href = "/mypage/init"
  </script>
</head>
<body>
</body>
</html>