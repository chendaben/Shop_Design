<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加书籍</title>
<link rel="stylesheet" href="css/adminBookOper.css">
<script type="application/javascript" src="vendor/adminBookOper.js"></script>
</head>
<body>
	<form id="book" name="book"
		action="${pageContext.request.contextPath}/admin_add" method="POST"
		enctype="multipart/form-data">
		<table id="operTable" cellpadding="10">
			<caption>添加管理员</caption>
			<tr>
				<td>管理员姓名</td>
				<td><input type="text" id="username" name="username"
					class="addInput" onblur="validateName();" /></td>
				<td id="name" style="color: #ff0000"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" id="userpassword" name="userpassword"
					class="addInput" /></td>
				<td id="userpassword" style="color: #ff0000"></td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><input type="text" id="userphone" name="userphone"
					class="addInput" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" id="useremail" name="useremail"
					class="addInput" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="保存"><div style="color: red">${error}</div></td>
				<td><a
					href="${pageContext.request.contextPath}/book_list?pageNo=1&pageSize=6">返回到书籍列表</a></td>
			</tr>
		</table>
	</form>
</body>
</html>