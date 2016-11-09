<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">  <!--禁止IE的兼容模式-->
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人中心</title>
<link href="css/project.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="vendor/jquery-1.11.3.min.js"></script>
<script src="vendor/bootstrap.min.js"></script>
<script type="text/javascript" src="vendor/project.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <form action="">
            <div class="col-md-12 col-lg-12 informationList">
                <div class="row">
                    <div class="col-md-4 col-lg-4 text-center">
                        <img src="image/picture.jpg" alt="" class="avatar">
                    </div>
                    <div class="col-md-6 col-lg-6">
                        <table class="table table-hover table-trap">
                            <tr>
                                <td><label for="username">昵称：</label></td>
                                <td><input type="text" name="username" id="username" value="${user.username}" class="form-control preSelect" disabled></td>
                            </tr>
                            <tr>
                                <td><label for="sex">性别：</label></td>
                                <td>
                                    <select name="sex" id="sex" class="form-control preSelect" disabled="disabled">
                                        <option value="1">男</option>
                                        <option value="0" selected="selected">女</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><label for="phone">电话号码：</label></td>
                                <td><input type="text" id="phone" value="${user.userphone}" class="form-control preSelect" disabled></td>
                            </tr>
                            <tr>
                                <td><label for="email">电子邮箱：</label></td>
                                <td><input type="text" id="email" value="${user.useremail}" class="form-control preSelect" disabled></td>
                            </tr>
                            <tr>
                                <td><label for="address">收货地址：</label></td>
                                <td><input type="text" id="address" value="四川成都" class="form-control preSelect" disabled></td>
                            </tr>
                            <tr>
                                <td><label for="other">其他信息：</label></td>
                                <td><input type="text" id="other" value="其他信息" class="form-control preSelect" disabled></td>
                            </tr>
                        </table>
                    </div>
                    <div class="col-md-2 col-lg-2">
                        <button class="btn btn-warning modifySelfMessage" type="button">修改个人信息</button>
                    </div>
                </div>
            </div>
            <div class="col-md-12 col-lg-12 text-center"><button type="submit" class="btn btn-info">保存修改</button>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/index" class="btn btn-info">返回首页</a></div>
        </form>

    </div>
</div>
</body>
</html>