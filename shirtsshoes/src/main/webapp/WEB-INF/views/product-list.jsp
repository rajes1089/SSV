<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"></c:url>">
</head>
<body>

<jsp:include page="header.jsp"><jsp:param value="product" name="actTab"/></jsp:include>

<div class="container">

	<div class="panel panel-default">
		<div class="panel-heading">
			<h2>Products</h2>
		</div>
		<div class="panel-body">
			<table class="table table-striped table-hover">
				<thead>
				<tr>
					<th>ID</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Category</th>
					<th>Availability</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td width="5%">${product.id}</td>
						<td width="15%">${product.name}</td>
						<td width="40%">${product.description}</td>
						<td width="10%">${product.category}</td>
						<td width="10%">${product.available}</td>
						<td width="5%">${product.price}</td>
						<td width="15%">
							<a href='<c:url value="/product/${product.id}"></c:url>'><button class="btn btn-warning">Edit</button></a>
							<a href='<c:url value="/product/${product.id}/delete"></c:url>'><button class="btn btn-danger">Delete</button></a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<h4 align="left">
				<a href='<c:url value="/product/add"></c:url>'><button class="btn btn-primary">Add New Product</button></a>
			</h4>
			</tbody>
		</div>
	</div>
</div></body>
</html>