<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>购物车</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/shopCart.css"/>
	<script src="vendor/jquery-1.11.3.min.js"></script>
	<script src="vendor/bootstrap.min.js"></script>
	<script src="vendor/shopCart.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			//此处应该遍历
			$("#sum").keyup(function(){
				//当按钮被松开时，发生 keyup 事件。它发生在当前获得焦点的元素上。
				$("#money").html(Number($("#price").text())*Number($("#sum").val()));
			});
		});
	</script>
</head>
<body>
<div id="shopCart_title"><a href="${pageContext.request.contextPath}/index">返回首页</a>&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/user_edit">个人中心</a>&nbsp;&nbsp;&nbsp;
<a href="###">我的订单</a></div>
<div id="title">购物车</div>
<table class="table table-striped" border="1">
	<thead>
	<tr>
		<th></th>
		<th>书名</th>
		<th>价格</th>
		<th>数量</th>
		<th>价格</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${shopBooks}" var="shopBook">
		<tr>
			<td>
				<input type="checkbox">
			</td>
			<td>
				<ul>
					<c:forEach items="${shopBook.books}" var="book">
						<li>${book.bookname}</li>
					</c:forEach>
				</ul>
			</td>
			<td id="price">
				${shopBook.price }
			</td>
			<td><input type="number" value="${shopBook.ordermount}" id="sum" min="1"/></td>
			<td><span id="money">0.0</span>元</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="5" id="page"><a>上一页</a> <a>下一页</a></td>
	</tr>
	<tr>
		<td colspan="5">总价：<span id="totalPrice"></span></td>
	</tr>
	<tr>
		<td colspan="5">
			<button type="button" class="btn btn-primary">提交订单</button>
		</td>
	</tr>
	</tbody>
</table>
</body>
</html>