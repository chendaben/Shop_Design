<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理</title>
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/all.css" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="vendor/jquery-1.11.3.min.js"></script>
<script src="vendor/bootstrap.min.js"></script>
</head>
<body>
	<div id="navigation_chen">
		<a href="${pageContext.request.contextPath}/">退出登录</a>&nbsp&nbsp&nbsp&nbsp
		<a href="${pageContext.request.contextPath}/go_navigation">管理导航</a>
	</div>
	<div class="container">
		<h2>
			用户信息管理 <small>${user.username} 管理员，欢迎您！</small>
		</h2>
		<a class="btn btn-info btn-sm"
			href="${pageContext.request.contextPath}/go_adminAdd"> <span
			class="glyphicon glyphicon-plus"></span>添加新的管理员
		</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>用户Id</th>
					<th>用户名</th>
					<th>电话号码</th>
					<th>电子邮件</th>
					<th>密码</th>
					<th>用户等级</th>
					<th>使用状态</th>
					<th>修改</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.userid}</td>
						<!--  
						<td><ol>
								<c:forEach items="${book.images}" var="image">
									<li>${image.originalFilename }<img
										src='<c:url value="/resources/image/"/>' width="100"
										${image.originalFilename } />
									</li>
								</c:forEach>
							</ol></td>
						-->
						<td><a href="${pageContext.request.contextPath}/user_edit?userid=${user.userid}">${user.username}</a></td>
						<td>${user.userphone}</td>
						<td>${user.useremail }</td>
						<td>${user.userpassword }</td>
						<td>${user.usergrade }</td>
						<td><c:if test="${user.userisuse==1}">
								<c:out value="使用中" />
							</c:if>
							<c:if test="${user.userisuse==0}">
								<c:out value="禁用中" />
							</c:if>
						</td>
						<td><a
							href="${pageContext.request.contextPath}/user_edit/${user.userid}"
							class="btn btn-info btn-sm"><span
								class="glyphicon glyphicon-pencil"></span>禁用</a></td>
						<td><a
							href="${pageContext.request.contextPath}/user_delete/${user.userid}"
							class="btn btn-info btn-sm"><span
								class="glyphicon glyphicon-minus"></span>彻底删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="paginationdiv">
		<ul class="pagination">
			<li><a href="#">首页</a></li>
			<li><a href="#">上一页</a></li>
			<li><a href="#">下一页</a></li>
			<li><a href="#">尾页</a></li>
		</ul>
	</div>
</body>
</html>