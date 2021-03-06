<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"></c:url>">
</head>
<body>

<jsp:include page="header.jsp"><jsp:param value="order" name="actTab"/></jsp:include>

<div class="container">
	
	<div class="panel panel-default">
		<div class="panel-heading">
			<h2>Orders</h2>
		</div>
		<div class="panel-body">
		<table class="table table-striped table-hover">
			<thead>
			<tr>
				<th>ID</th>
				<th>Date</th>
				<th>Customer</th>
				<th>Total</th>
				<th>Created User</th>
				<th>Action</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${orders}" var="order">
				<tr>
					<td width="10%">
						${order.id}
					</td>
					<td width="15%">
						${order.timeStamp}
					</td>
					<td width="25%">
						${order.customer.firstName}&nbsp;${order.customer.lastName}
					</td>
					<td width="15%">
						$&nbsp;${order.total}
					</td>
					<td width="15%">
						${order.user.userName}
					</td>
					<td width="20%">
						<a href='<c:url value="/order/${order.id}"></c:url>'><button class="btn btn-warning">Edit</button></a>
						<a href='<c:url value="/order/${order.id}/delete"></c:url>'><button class="btn btn-danger">Delete</button></a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<h4 align="left">
			<a href='<c:url value="/order/add"></c:url>'><button class="btn btn-primary">New Order</button></a>
		</h4>
		</div>
	</div>
</div></body>
</html>