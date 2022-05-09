<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
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
                        <a class="dropdown-item" href="#">Another action</a>
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
        <a class="nav-link" href="/mypage/private-info">개인 정보</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/mypage/attendance">근태 기록</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/mypage/annual-leave">연차 기록</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/mypage/paystub">급여 명세서</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="/mypage/phonebook">주소록</a>
    </li>
</ul>
<ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="/mypage/phonebook">주소록</a></li>
    <li class="breadcrumb-item active"><a href="">주소록 추가</a></li>
</ol>


<form class="form-parent"
      method="post" action="/mypage/insertPhoneBook.do">
    <fieldset>
        <legend>주소록 추가</legend>
        <div class="form-group row">
            <label for="staticPb_Cpn" class="col-sm-2 col-form-label">회사 명</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="staticPb_Cpn"
                       name="pb_Cpn">
            </div>
        </div>
        <div class="form-group row">
            <label for="staticPb_Name" class="col-sm-2 col-form-label">이 름</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="staticPb_Name"
                       name="pb_Name">
            </div>
        </div>
        <div class="form-group row">
            <label for="staticPb_PhoneNumber" class="col-sm-2 col-form-label">전화번호</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="staticPb_PhoneNumber"
                       name="pb_PhoneNumber">
            </div>
        </div>
        <div class="form-group row">
            <label for="staticPb_Rank" class="col-sm-2 col-form-label">직급</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="staticPb_Rank"
                       name="pb_Rank">
            </div>
        </div>
        <div class="form-group row">
            <label for="staticPb_Email" class="col-sm-2 col-form-label">이메일</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="staticPb_Email"
                       name="pb_Email">
            </div>
        </div>
        <div class="d-grid gap-2">
            <button class="btn btn-lg btn-primary" type="submit">저장</button>
        </div>
    </fieldset>
</form>
</body>
</html>

