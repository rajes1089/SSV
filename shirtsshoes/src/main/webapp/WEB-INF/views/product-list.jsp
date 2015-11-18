<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"></c:url>">
</head>
<body class="container-fluid">
	<h1>Products</h1>
	<table class="table table-striped table-hover">
		<tr>
			<th>ID</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Category</th>
			<th>Availability</th>
			<th>Price</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.category}</td>
				<td>${product.available}</td>
				<td>${product.price}</td>
				<td>
					<a href='<c:url value="/product/${product.id}"></c:url>'><button class="btn btn-warning">Edit</button></a>
					<a href='<c:url value="/product/${product.id}/delete"></c:url>'><button class="btn btn-danger">Delete</button></a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<h4 align="left">
		<a href='<c:url value="/product/add"></c:url>'><button class="btn btn-primary">Add New Product</button></a>
	</h4>
</body>
</html>