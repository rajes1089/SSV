<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"></c:url>">
</head>
<body>
<jsp:include page="header.jsp"><jsp:param value="customer" name="actTab"/></jsp:include>
<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h2>Customers</h2>
		</div>
		<div class="panel-body">
				<table class="table table-striped table-hover">
					<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Address</th>
						<th>Phone Number</th>
						<th>Credit Limit</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${customers}" var="customer">
						<tr>
							<td width="5%">
								${customer.id}
							</td>
							<td width="10%">
								${customer.firstName}
							</td>
							<td width="10%">
								${customer.lastName}
							</td>
							<td width="20%">
								${customer.streetAddress1}<br>
								<c:if test="${not empty customer.streetAddress2}">
									${customer.streetAddress2}<br>
								</c:if>
								${customer.city}<br>
								${customer.state}<br>
								${customer.postalCode}
							</td>
							<td width="15%">
								${customer.phoneNumber1}<br>
								${customer.phoneNumber2}
							</td>
							<td width="10%">
								${customer.creditLimit}
							</td>
							<td width="15%">
								<c:if test="${empty customer.email}">
									NA
								</c:if>
								<c:if test="${not empty customer.email}">
									${customer.email}
								</c:if>
								
							</td>
							<td width="15%">
								<a href='<c:url value="/customer/${customer.id}"></c:url>'><button class="btn btn-warning">Edit</button></a>
								<a href='<c:url value="/customer/${customer.id}/delete"></c:url>'><button class="btn btn-danger">Delete</button></a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<h4 align="left">
					<a href='<c:url value="/customer/add"></c:url>'><button class="btn btn-primary">Add New Customer</button></a>
				</h4>
			</div>
		</div>
</div></body>
</html>