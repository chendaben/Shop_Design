<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>书籍详情</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="css/common.css" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="vendor/jquery-1.11.3.min.js"></script>
<script src="vendor/bootstrap.min.js"></script>
</head>
<body class="body">
	<div class="center">
		<form id="book" name="book"
			action="${pageContext.request.contextPath}/insertShopCart/${book.bookid}"
			method="POST">
			<table class="commonTable" cellspacing="0" width="25%">
				<caption style="font-size: 25px;color: blue">书籍信息</caption>
				<tr><td colspan="2"><img src="${book.imageUrl}" alt="" width="150px" height="200px"></td></tr>
				<tr>
					<td><span class="label label-info">书名</span></td>
					<td><input type="text" id="bookname" name="bookname"
						value="${book.bookname }" disabled /></td>
				</tr>

				<tr>
					<td><span class="label label-info">作者</span></td>
					<td><input type="text" id="bookauthor" name="bookauthor"
						value="${book.bookauthor }" disabled /></td>
				</tr>

				<tr>
					<td><span class="label label-info">出版社</span></td>
					<td><input type="text" id="bookpress" name="bookpress"
						value="${book.bookpress}" disabled /></td>
				</tr>
				<tr>
					<td><span class="label label-info">价格</span></td>
					<td><input type="text" id="bookprice" name="bookprice"
						value="${book.bookprice }" disabled /></td>
				</tr>
				<tr>
					<td><input type="submit" value="加入购物车" class="btn btn-primary" /></td>
					<td><a class="btn btn-success" href="${pageContext.request.contextPath}/index">返回首页</a></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
	
	</script>
</body>
</html>