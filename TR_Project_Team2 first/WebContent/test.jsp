<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/Animation/Animation.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style type="text/css">

a{color:#58bff6;text-decoration: none;}
a:hover{color:#aaa; }
.pull-right{float: right;}
.pull-left{float: left;}
.clear-fix{clear:both;}
div.logo{text-align: center; margin: 20px 20px 30px 20px; fill: #566375;}
.head{padding:40px 0px; 10px 0}
.logo-active{fill: #44aacc !important;}
#formWrapper{
	background: rgba(0,0,0,.2); 
	width:100%; 
	height:100%; 
	position: absolute; 
	top:0; 
	left:0;
	transition:all .3s ease;}
.darken-bg{background: rgba(0,0,0,.5) !important; transition:all .3s ease;}

div#form{
	position: absolute;
	width:360px;
	height:320px;
	height:auto;
	background-color: #fff;
	margin:auto;
	border-radius: 5px;
	padding:20px;
	left:50%;
	top:50%;
	margin-left:-180px;
	margin-top:-200px;
}
div.form-item{position: relative; display: block; margin-bottom: 40px;}
 input{transition: all .2s ease;}
 input.form-style{
	color:#8a8a8a;
	display: block;
	width: 90%;
	height: 44px;
	padding: 5px 5%;
	border:1px solid #ccc;
	-moz-border-radius: 27px;
	-webkit-border-radius: 27px;
	border-radius: 27px;
	-moz-background-clip: padding;
	-webkit-background-clip: padding-box;
	background-clip: padding-box;
	background-color: #fff;
	font-family:'HelveticaNeue','Arial', sans-serif;
	font-size: 105%;
	letter-spacing: .8px;
}
div.form-item .form-style:focus{outline: none; border:1px solid #58bff6; color:#58bff6; }
div.form-item p.formLabel {
	position: absolute;
	left:26px;
	top:10px;
	transition:all .4s ease;
	color:#bbb;}
.formTop{top:-22px !important; left:26px; background-color: #fff; padding:0 5px; font-size: 14px; color:#58bff6 !important;}
.formStatus{color:#8a8a8a !important;}
input[type="submit"].login{
	float:right;
	width: 112px;
	height: 37px;
	-moz-border-radius: 19px;
	-webkit-border-radius: 19px;
	border-radius: 19px;
	-moz-background-clip: padding;
	-webkit-background-clip: padding-box;
	background-clip: padding-box;
	background-color: #55b1df;
	border:1px solid #55b1df;
	border:none;
	color: #fff;
	font-weight: bold;
}
input[type="submit"].login:hover{background-color: #fff; border:1px solid #55b1df; color:#55b1df; cursor:pointer;}
input[type="submit"].login:focus{outline: none;}

</style>
</head>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script src="https://code.jquery.com/jquery-2.1.0.min.js" ></script>
<body>
<div id="formWrapper">

<div id="form">
<div class="logo">
<h1 class="text-center head">The form</h1>
</div>
		<div class="form-item">
			<p class="formLabel">Email</p>
			<input type="email" name="email" id="email" class="form-style" autocomplete="off"/>
		</div>
		<div class="form-item">
			<p class="formLabel">Password</p>
			<input type="password" name="password" id="password" class="form-style" />
			<!-- <div class="pw-view"><i class="fa fa-eye"></i></div> -->
			<p><a href="#" ><small>Forgot Password ?</small></a></p>	
		</div>
		<div class="form-item">
		<p class="pull-left"><a href="#"><small>Register</small></a></p>
		<input type="submit" class="login pull-right" value="Log In">
		<div class="clear-fix"></div>
		</div>
</div>
</div>
</body>
</html>