<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>书店管理导航</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <style type="text/css">
        body{
            margin: 0;
            padding: 0;
            font-size: large;
            color:#f5f5f5;
            background-color: #269abc;
        }
        #man{
            margin: 20px auto ;
            width: 400px;
            height: 300px;
            border: dashed;
        }
        h2{
            text-align: center;
        }
        ul{
            margin: 0 auto;
            width: 150px;
        }
        li{

            line-height: 50px;
        }
        /*设置链接样式*/
        a{
            color: blanchedalmond;
        }
        a:hover{
            color: #000000;
        }
        /*设置导航栏*/
        #loginout{
            border-bottom: solid;
            padding-left: 80%;
        }
        /*设置标题样式*/
        #title{
            /*border-bottom: solid;*/
            padding-left: 41%;
            height: 90px;
            font-family: "微软雅黑", 'Open Sans', "Microsoft Yahei", "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-size: 40px;
        }
    </style>
</head>
<body>
<div id="loginout"><a href="${pageContext.request.contextPath}/">退出登录</a></div>
<div id="title">图书管理系统</div>
<div id="man">
    <h2>管理导航</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/book_list?pageNo=1&pageSize=6">书籍管理</a></li>
        <li><a href="${pageContext.request.contextPath}/user_list">用户管理</a></li>
        <li><a href="${pageContext.request.contextPath}/#">订单管理</a></li>
        <li><a href="${pageContext.request.contextPath}/#">物流管理</a></li>

    </ul>
</div>
</body>
</html>