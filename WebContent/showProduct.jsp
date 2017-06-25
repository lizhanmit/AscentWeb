<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*, com.ascent.bean.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>My JSP 'showProduct.jsp' starting page</title>
</head>
<body>
	<center>
		<h1>Product List</h1>
		<table>
			<tbody>
				<tr bgcolor="#fba661">
					<td>Product Number</td>
					<td>Product Name</td>
					<td>Category</td>
					<td>Price</td>
					<td>Image</td>
					<td>Buy</td>
				</tr>
				
				<c:forEach var="p" items="${allProduct}">
					<tr>
						<td>${p.productnumber}</td>
						<td>${p.productname}</td>
						<td>${p.category}</td>
						<td>${p.price}</td>
						<td><img height="50" src="<%= request.getContextPath() %>/images/${p.imagePath}" /></td>
						<td><button onclick="addshop(${p.id})">Buy</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>