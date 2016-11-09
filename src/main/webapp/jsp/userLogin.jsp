<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>图书管理系统</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/main.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="vendor/jquery-1.11.3.min.js"></script>
<script src="vendor/bootstrap.min.js"></script>
</head>
<body>
	<section id="login-container">
	<div class="row">
		<div class="col-md-3" id="login-wrapper">
			<div class="panel panel-primary animated flipInY">
				<div class="panel-heading">
					<h3 class="panel-title">网络书店用户登录</h3>
				</div>
				<div class="panel-body">
					<p>输入账户信息</p>
					<form class="form-horizontal" role="form" name="form1"
						id="loginForm" action="${pageContext.request.contextPath}/login"
						method="post">
						<div class="form-group">
							<div class="col-md-12">
								<input type="text" class="form-control" name="UserPhone"  id="UserPhone"
									placeholder="请输入电话号码" style="padding-bottom: 0; padding-top: 0">
								<i class="fa fa-user"></i>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<input type="password" class="form-control" name="UserPassword" id="UserPassword"
									placeholder="请输入密码" style="padding-bottom: 0; padding-top: 0">
								<i class="fa fa-lock"></i>
							</div>
						</div>
						<div class="alert alert-warning alert-block" id="alert_info"
							style="display: none">
							<p id="msg"></p>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<a href="javascript:void(0)"
									class="btn btn-default  btn-info btn-block"
									id="submit_signin_btn">登录</a>
								<hr />
								<a href="${pageContext.request.contextPath}/go_regist"
									class="btn btn-default btn-block">没有帐号? 马上注册>>></a>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<span class="form-error" id="error" hidden="hidden">用户名或者密码错误</span>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</section>
	<script type="text/javascript">

		//ajax post方式提交登录数据
		<%--$("#submit_signin_btn").click(function () {--%>
			<%--$.post("${pageContext.request.contextPath}/login",{--%>
				<%--UserPhone:$("#UserPhone").val(),--%>
				<%--UserPassword:$("#UserPassword").val()--%>
			<%--},function (data,textStatus) {--%>
				<%--window.alert("data");--%>

			<%--})--%>
		<%--})--%>

		//ajax方式提交
		$("#submit_signin_btn").click(function () {
			$.ajax({
				    type:'post',
				    dataType:'json',
				    url:'${pageContext.request.contextPath}/login',
					data:{
						UserPhone:$("#UserPhone").val(),
						UserPassword:$("#UserPassword").val()
					},
					success:function (data,status) {
						console.log(data);
						console.log(data.usergrade);
						if(data!=null){
							console.log("登录成功");
                            //如果错误信息是显示的，则隐藏它.
                            if(!$("#error").is(":hidden")){
                                $("#error").hide();
                            }
                            var usergrade=data.usergrade;
							window.location.href="${pageContext.request.contextPath}/index?usergrade="+usergrade;
						}else{
							$("#error").show();
						}
					},
					error:function () {
						alert("登录异常");
					}


		})

		})

	</script>
</body>
</html>