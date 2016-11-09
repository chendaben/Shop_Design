<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>图书管理系统</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="css/style.css" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/main.css">
<script src="vendor/jquery-1.11.3.min.js"></script>
<script src="vendor/jquery.validate-1.13.1.js"></script>
<script src="vendor/bootstrap.min.js"></script>
</head>
<body>
	<section id="login-container">
	<div class="row">
		<div class="col-md-3" id="login-wrapper">
			<div class="panel panel-primary animated">
				<div class="panel-heading">
					<h3 class="panel-title">网络书店用户注册</h3>
				</div>
				<div class="panel-body">
					<p>输入注册信息</p>
					<div class="alert alert-warning alert-block" id="alert_info"
						style="display: none">
						<p id="msg"></p>
					</div>
					<form class="form-horizontal" name="form1" id="registForm"
						action="${pageContext.request.contextPath}/regist" method="POST"
						onsubmit="checkform()">
						<div class="form-group">
							<div class="col-md-12">
								<input type="text" class="form-control" name="username"
									placeholder="请输入用户名" style="padding-bottom: 0; padding-top: 0">
								<i class="fa fa-user"></i>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-12">
								<input type="password" class="form-control" name="userpassword"
									placeholder="请输入密码" style="padding-bottom: 0; padding-top: 0">
								<i class="fa fa-lock"></i>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-12">
								<input type="text" class="form-control" name="userphone" id="userphone"
									placeholder="请输入电话号码" style="padding-bottom: 0; padding-top: 0" onblur="isvalidate()">
								<i class="fa fa-lock"></i>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-12">
								<input type="text" class="form-control" name="useremail"
									placeholder="请输入邮箱" style="padding-bottom: 0; padding-top: 0">
								<i class="fa fa-lock"></i>
							</div>
						</div>
						<!-- <div class="form-group">
								<div class="col-md-12">
								请选择性别：
									男&nbsp;<input type="radio" name="sex[]" value="0" checked style="margin-right:30px"/>
									女&nbsp;<input type="radio" name="sex[]" value="1" />
								</div>
							</div> -->

						<div class="form-group">
							<div class="col-md-12">
								<a href="javascript:void(0)"
									class="btn btn-default  btn-info btn-block"
									id="submit_register_btn" onclick="regist()">注册</a>
								<h4 class="text-muted text-center">
									<small>已经有账号了?</small>
								</h4>
								<a href="${pageContext.request.contextPath}/go_login"
									class="btn btn-default btn-block">直接登录</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</section>
	<script type="text/javascript">
		function regist() {
			document.getElementById("registForm").submit();
		}
		//验证用户注册时候输入的合法性
		function checkform(){
			
		}
		
		//验证电话号码是否已存在
		function isvalidate(){
			var phone=document.getElementById("userphone").value;
			$ajax({
				type:"GET",
				url:"/check",
				data:"phone="+phone,
				dataType:'json',
				success:function(msg){
					
				}
			})
		}
	</script>

</body>
</html>