<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>书籍管理</title>
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/book.css" />
<link rel="stylesheet" href="css/all.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
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
			书籍信息管理 <small>${user.username} 欢迎您！</small>
		</h2>
		<!-- 搜索显示 -->
		<div class="search">
			<form class="bs-example bs-example-form" id="search" action="${pageContext.request.contextPath}/book_list" method="get">
				<div class="col-lg-6">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="搜索(书籍名称)" name="name" id="name">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button" onclick="search()">Search</button>
						</span>
					</div>
				</div>
			</form>
		</div>
		<a class="btn btn-info btn-sm"
			href="${pageContext.request.contextPath}/book_input"> <span
			class="glyphicon glyphicon-plus"></span>添加
		</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>书籍id</th>
					<th>图片</th>
					<th>书名</th>
					<th>作者</th>
					<th>出版社</th>
					<th>价格</th>
					<th>所属类别</th>
					<th>总数量</th>
					<th>剩余数量</th>
					<th>修改</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookList}" var="book">
					<tr>
						<td>${book.bookid}</td>
						<td>
							<img src="${book.imageUrl}" width="100px" height="120px"/>
						</td>
						<td><a href="#">${book.bookname}</a></td>
						<td>${book.bookauthor}</td>
						<td>${book.bookpress }</td>
						<td>${book.bookprice }</td>
						<td>${book.category.categoryname }</td>
						<td>${book.booktotalnum }</td>
						<td>${book.bookremainnum }</td>
						<td><a
							href="${pageContext.request.contextPath}/book_edit?bookid=${book.bookid}"
							class="btn btn-info btn-sm"><span
								class="glyphicon glyphicon-pencil"></span> 修改</a></td>
						<td><a
							href="${pageContext.request.contextPath}/book_delete/${book.bookid}"
							class="btn btn-info btn-sm"><span
								class="glyphicon glyphicon-minus"></span> 删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="paginationdiv">
			<ul class="pagination">
				<li><a href="${pageContext.request.contextPath}/book_list">首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/book_list?pageNo=${pageNo-1}"
					<c:if test="${pageNo==1}">hidden</c:if>>上一页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/book_list?pageNo=${pageNo+1}"
					<c:if test="${pageNo==pageSum}">hidden</c:if>>下一页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/book_list?pageNo=${pageSum}">尾页</a></li>
			</ul>
		</div>
	</div>
	<script type="text/javascript">
	function search(){
		document.getElementById("search").submit();
	}
	</script>
</body>
</html>