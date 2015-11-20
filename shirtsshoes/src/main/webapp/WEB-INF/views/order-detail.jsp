<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Detail</title>
<link rel="stylesheet"  href="<c:url value="/resources/css/bootstrap.min.css"></c:url>">
</head>
<body><div class="container">

<jsp:include page="header.jsp"><jsp:param value="order" name="actTab"/></jsp:include>

<h3>Order Detail</h3>

<h4 align="left">&nbsp;Order Id : ${order.id}</h4>

<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>Order Id</th>
			<th>Order Item Id</th>
			<th>Product</th>
			<th>Quantity</th>
			<th>Unit Price</th>
			<th>Total Price</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${order.orderItems}" var="orderItem">
		<tr>
			<td>${order.id}</td>
			<td>${orderItem.id}</td>
			<td>${orderItem.product.name}</td>
			<td>${orderItem.quantity}</td>
			<td>$&nbsp;${orderItem.product.price}</td>
			<td>$&nbsp;${orderItem.product.price * orderItem.quantity}</td>
		</tr>	
	</c:forEach>
		<tr>
			<td colspan="5" align="right"><strong>Total Order Cost</strong></td>
			<td><strong>$&nbsp;${order.total}</strong></td>
		</tr>
	</tbody>
</table>

</div></body>
</html>