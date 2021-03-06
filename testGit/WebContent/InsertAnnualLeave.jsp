<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"--%>
<%--            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"--%>
<%--            crossorigin="anonymous"></script>--%>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}Resource/CSS/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap_modify.css" type="text/css">
    <script>
        function changeSelect(frm) {
            var select = frm.an_distinct.selectedIndex + 1;
            switch (select) {
                case 1:
                    frm.an_deduction.value = 0.25;
                    break;
                case 2:
                    frm.an_deduction.value = 0.25;
                    break;
                case 3:
                    frm.an_deduction.value = 1;
                    break;
                case 4:
                    frm.an_deduction.value = 1;
                    break;
                case 5:
                    frm.an_deduction.value = 0.5;
                    break;
                case 6:
                    frm.an_deduction.value = 0.5;
                    break;
                case 7:
                    frm.an_deduction.value = 0;
                    break;
                case 8:
                    frm.an_deduction.value = 0;
                    break;
            }
        }
    </script>

    <script type="text/javascript">
        $(function () {
            $('#datetimepicker1').datetimepicker({ format: 'L'});
            $('#datetimepicker2').datetimepicker({ format: 'L', useCurrent: false });
            $("#datetimepicker1").on("change.datetimepicker", function (e) {
                $('#datetimepicker2').datetimepicker('minDate', e.date);
            });
            $("#datetimepicker2").on("change.datetimepicker", function (e) {
                $('#datetimepicker1').datetimepicker('maxDate', e.date);
            });
        });

        document.getElementById("current").value = "??????";
    </script>
    <style>
        .form-group{
            padding-bottom:30px;
        }
        .datetimepicker-input{
            margin-left:10px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">StarWorks</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="mainAction.do">???
                        <span class="visually-hidden">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/testGit/document/listAction.do">????????????</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/testGit/schedule/moveSchedule.do">????????????</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/testGit/Meetingroom/listNoticeAction.do">????????????</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/testGit/community/listCommunityAction.do">????????????</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/testGit/views/MyPage/Init.jsp">???????????????</a>
                </li>
            </ul>
            <form class="d-flex">
                <a class="nav-link" href="logOutAction.do" id = "logout">????????????</a>
            </form>
        </div>
    </div>
</nav>

<ul class="nav nav-pills flex-column">
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/private-info.do">?????? ??????</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/attendance.do">?????? ??????</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="${sessionScope.contextPath}/mypage/annual-leave.do">?????? ??????</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/paystub.do">?????? ?????????</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/phonebook.do">?????????</a>
    </li>
</ul>
<ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="${sessionScope.contextPath}/mypage/annual-leave.do">?????? ??????</a></li>
    <li class="breadcrumb-item active"><a href="">?????? ??????</a></li>
</ol>


<form class="form-parent"
      method="post" action="${sessionScope.contextPath}/mypage/insertAnnualLeave.do">
    <fieldset>
        <legend>?????? ??????</legend>
        <div class="form-group">
            <label for="an_distinct" class="col-sm-2 col-form-label">?????? ???</label>
            <select class="form-select" id="an_distinct"
                    style="width:340px" name="an_distinct"
                    onChange="changeSelect(this.form)">
                <option value="1">??????</option>
                <option value="2">??????</option>
                <option value="3">??????</option>
                <option value="4">??????</option>
                <option value="5">????????????</option>
                <option value="6">????????????</option>
                <option value="7">????????????</option>
                <option value="8">??????</option>
            </select>
        </div>
        <div class="form-group">
            <label for="staticAn_deduction" class="col-sm-2 col-form-label">?????? ?????????</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="staticAn_deduction"
                       name="an_deduction" value="0.25">
            </div>
        </div>

        <div class='col-md-3 col-xs-4'>
            <div class="form-group">
                <label for="datetimepicker1" class="col-sm-2 col-form-label">?????? ???</label>
                <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
                    <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker1" name="an_startDate">
                    <div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
                        <div class="input-group-text">
                            <i class="fa fa-calendar"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class='col-md-3 col-xs-4'>
            <div class="form-group">
                <label for="datetimepicker2" class="col-sm-2 col-form-label">?????? ???</label>
                <div class="input-group date" id="datetimepicker2" data-target-input="nearest">
                    <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker2" name="an_endDate">
                    <div class="input-group-append" data-target="#datetimepicker2" data-toggle="datetimepicker">
                        <div class="input-group-text">
                            <i class="fa fa-calendar"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="d-grid gap-2">
            <button class="btn btn-lg btn-primary" type="submit">??????</button>
        </div>
    </fieldset>
</form>
</body>
</html>

