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
		action="${pageContext.request.contextPath}/book_save" method="POST"
		enctype="multipart/form-data">
		<table id="operTable" cellpadding="10">
			<caption>添加书籍</caption>
			<tr>
				<td>书名</td>
				<td><input type="text" id="bookname" name="bookname"
					class="addInput" onblur="validateName();" /></td>
				<td id="name" style="color: #ff0000"></td>
			</tr>
			<tr>
				<td>作者</td>
				<td><input type="text" id="bookauthor" name="bookauthor"
					class="addInput" /></td>
				<td id="author" style="color: #ff0000"></td>
			</tr>
			<tr>
				<td>出版社</td>
				<td><input type="text" id="bookpress" name="bookpress"
					class="addInput" /></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" id="bookprice" name="bookprice"
					class="addInput" /></td>
			</tr>
			<tr>
				<td>类别</td>
				<td><select id="categoryId" name="categoryId" class="addInput">
						<c:forEach items="${categories}" var="category">
							<option value="${category.categoryid}">${category.categoryname}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>总数量</td>
				<td><input type="number" id="booktotalnum" name="booktotalnum"
					class="addInput" /></td>
			</tr>
			<tr>
				<td>剩余量</td>
				<td><input type="number" id="bookremainnum"
					name="bookremainnum" class="addInput" /></td>
			</tr>
			<tr>
				<td>书图片</td>
				<td><input type="file" id="images" name="images[0]"
					class="addInput" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="保存"></td>
				<td><a
					href="${pageContext.request.contextPath}/book_list?pageNo=1&pageSize=6">返回到书籍列表</a></td>
			</tr>
		</table>
	</form>
</body>
</html>