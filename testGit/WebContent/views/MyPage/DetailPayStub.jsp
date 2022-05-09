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
        <a class="nav-link active" href="/mypage/paystub">급여 명세서</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/mypage/phonebook">주소록</a>
    </li>
</ul>
<ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="/mypage/paystub">급여 명세서</a></li>
    <li class="breadcrumb-item active"><a href="#">자세히 보기</a></li>
</ol>


<form class="form-parent">
    <fieldset>
        <legend>급여 명세서</legend>
        <div class="form-group row">
            <label for="staticE_No" class="col-sm-2 col-form-label">직원 번호</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticE_No"
                       name="e_No" value=${privateInfo.e_No}>
            </div>
        </div>
        <div class="form-group row">
            <label for="staticD_No" class="col-sm-2 col-form-label">이름</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticD_No"
                       name="d_No" value=${privateInfo.name}>
            </div>
        </div>
        <div class="form-group row">
            <label for="staticGrade" class="col-sm-2 col-form-label">직급</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticGrade"
                       name="grade" value=${privateInfo.grade}>
            </div>
        </div>
        <div class="form-group row">
            <label for="staticP_No" class="col-sm-2 col-form-label">번 호</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticP_No"
                       name="name" value=${detailPayStub.p_No}>
            </div>
        </div>
        <div class="form-group row">
            <label for="staticP_Date" class="col-sm-2 col-form-label">지급일</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticP_Date"
                       name="hireDate" value=${detailPayStub.p_Date}>
            </div>
        </div>
        <div class="form-group row">
            <label for="staticP_BasePay" class="col-sm-2 col-form-label">기본급</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticP_BasePay"
                       name="id" value=${detailPayStub.p_BasePay}>
            </div>
        </div>
        <div class="form-group row">
            <label for="staticMealAllowance" class="col-sm-2 col-form-label">식 대</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticMealAllowance"
                       name="phoneNumber" value=${detailPayStub.mealAllowance}>
            </div>
        </div>
        <div class="form-group row">
            <label for="staticIncomeTax" class="col-sm-2 col-form-label">소득세</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticIncomeTax"
                       name="phoneNumber" value=${detailPayStub.incomeTax}>
            </div>
        </div>
        <div class="form-group row">
            <label for="staticInhabitantsTax" class="col-sm-2 col-form-label">지방세</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticInhabitantsTax"
                       name="phoneNumber" value=${detailPayStub.inhabitantsTax}>
            </div>
        </div>
        <div class="form-group row">
            <label for="staticNationalPension" class="col-sm-2 col-form-label">국민연금</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticNationalPension"
                       name="phoneNumber" value=${detailPayStub.nationalPension}>
            </div>
        </div>
        <div class="form-group row">
            <label for="staticEmploymentInsurance" class="col-sm-2 col-form-label">고용보험</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticEmploymentInsurance"
                       name="phoneNumber" value=${detailPayStub.employmentInsurance}>
            </div>
        </div>
        <div class="form-group row">
            <label for="staticHealthInsurance" class="col-sm-2 col-form-label">건강보험</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticHealthInsurance"
                       name="phoneNumber" value=${detailPayStub.healthInsurance}>
            </div>
        </div>

        <div class="form-group row">
            <label for="staticP_NetPay" class="col-sm-2 col-form-label">실 수령액</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticP_NetPay"
                       name="phoneNumber" value=${detailPayStub.p_NetPay}>
            </div>
        </div>
    </fieldset>
</form>
</body>
</html>

