<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<link rel="stylesheet" href="css/LoginForm.css">
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>여행이 좋다,</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0" >
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">회원 가입</h1>
              </div>
              <form class="user" action ="SighUpok.do" method ="post">
               <div>
                  <div class="form-group" style = "width : 70%; float: left"> 
                    <input type="text" class="form-control form-control-user" id="id" name ="id" placeholder="ID를 입력해주세요.">
                  </div>
                  <input type = "button" value = "중복 확인" class="login pull-right" style = "border-radius : 5px; height: calc(1.5em + 1.55rem + 2px)"> 
             </div> 
                  <div class="form-group">
                    <input type="password" class="form-control form-control-user" id="password" name="password" placeholder="비밀번호를 입력해주세요.">
                  </div>
                  <div class="form-group" style = "width : 70%; float: left">
                    <input type="text" class="form-control form-control-user" id="name" name="name" placeholder="이름을 입력해주세요.">
                  </div>
                  <div style = "float: right">
                  	<label class="btn btn-primary">
                  	<span class ="ico">
						<input type="radio" name="gender" id="gender" value = "1">남
						</span>
					</label>
					<label class="btn btn-secondary">
					<span class ="ico">
					<input type="radio" name="gender" id="gender" value = "0">여
					</span>
						
					</label>
                  </div>
                   <div class="form-group">
                    <input type="text" class="form-control form-control-user" id="travel" name= "travel" placeholder="관심 지역을 입력해주세요.">
                  </div>
                <div class="form-group">
                  <input type="email" class="form-control form-control-user" id="email" name="email" placeholder="이메일을 입력해주세요.">
                </div>
                <div>
<!-- 비밀번호 확인[고민] <div class="col-sm-6">
                    <input type="password" class="form-control form-control-user" id="exampleRepeatPassword" placeholder="Repeat Password">
                  </div> -->
                </div>
                <input type="submit" id="sigh" name = "sigh" value="회원가입" class="btn btn-primary btn-user btn-block">
        		</form>
                <hr>
                <a href="Index.jsp" class="btn btn-google btn-user btn-block" style = "border-radius : 19px">
                  	다시 로그인 하러가기
                </a>

              
              <hr>
              <div class="text-center">
                <a class="small" href="forgot-password.html">Forgot Password?</a>
              </div>
              <div class="text-center">
                <a class="small" href="login.html">Already have an account? Login!</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

</body>

</html>
