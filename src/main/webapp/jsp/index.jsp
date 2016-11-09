<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>welcome,大奔的书店</title>
<link rel="stylesheet" href="css/project.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="vendor/jquery-1.11.3.min.js"></script>
<script src="vendor/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10 col-lg-10 bookLists">
				<ul class="row">
					<li class="col-md-2 col-lg-2"><a
						href="${pageContext.request.contextPath}/book_category">全部</a></li>
					<c:forEach items="${categoryList}" var="category">
						<li class="col-md-2 col-lg-2"><a
							href="${pageContext.request.contextPath}/book_category?categoryid=${category.categoryid}">${category.categoryname}</a></li>
					</c:forEach>
				</ul>
				<ul class="row">
					<c:forEach items="${bookList}" var="book">
						<li class="col-md-5ths col-lg-5ths">
							<div>
								<img src="${book.imageUrl}" alt="" width="150px" height="200px">
								<div>${book.bookname}￥${book.bookprice }</div>
								<a
									href="${pageContext.request.contextPath}/book_detail?bookid=${book.bookid}"
									class="btn btn-default pull-left btn-info">详情</a> <a
									href="${pageContext.request.contextPath}/insertShopCart/${book.bookid}"
									class="btn btn-default pull-right btn-success">加入购物车</a>
								<div style="clear: both"></div>
							</div>
						</li>
					</c:forEach>
				</ul>
				<div class="row">
					<div class="col-md-12 col-lg-12 text-center">
						<ul class="pagination">
							<li><a
								href="${pageContext.request.contextPath}/book_list?pageNo=1&pageSize=6">首页</a></li>
							<li><a
								href="${pageContext.request.contextPath}/book_list?pageNo=${param.pageNo-1}&pageSize=6">上一页</a></li>
							<li><a
								href="${pageContext.request.contextPath}/book_list?pageNo=${param.pageNo+1}&pageSize=6">下一页</a></li>
							<li><a
								href="${pageContext.request.contextPath}/book_list?pageNo=${(allList + param.pageSize -1)/param.pageSize}&pageSize=6">尾页</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-2 col-lg-2 text-center navManage">
				<div>
					<div>
					<form id="searchForm" action="${pageContext.request.contextPath}/books" method="get">
						<input type="text" placeholder="书籍名称" name="name" id="name"/> 
						<input type="submit" value="搜索" class="btn btn-default">
					</form>
					</div>
					<a class="btn btn-default btn-info" href="${pageContext.request.contextPath}/shopCart">我的购物车</a> 
					<a class="btn btn-default">我的订单</a> 
					<a href="${pageContext.request.contextPath}/user_edit" class="btn btn-default btn-success">我的个人中心</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>