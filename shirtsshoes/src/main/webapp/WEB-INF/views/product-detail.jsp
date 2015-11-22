<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Detail</title>
<link rel="stylesheet"  href="<c:url value="/resources/css/bootstrap.min.css"></c:url>">
</head>
<body>

<jsp:include page="header.jsp"><jsp:param value="product" name="actTab"/></jsp:include>

<div class="container">


<sf:form class="form-horizontal" role="form" modelAttribute="product">
<div class="panel panel-default">
	
	<div class="panel-heading">
		<h1>${product.name}<br><small>${product.description}</small></h1>
	</div>
	
	<div class="panel-body">
		<div class="row">
			
			<div class="col-md-8">
				<div class="thumbnail">
					<img src='<c:url value="/resources/img/${product.fileName}"></c:url>' alt="${product.name}">
				</div>
			</div>
			
			<div class="col-md-4">
				<!-- List group -->
				  <ul class="list-group">
				    <li class="list-group-item"><h3>Category : ${product.category}</h3></li>
				    <li class="list-group-item"><h3>Price : $&nbsp;${product.price}</h3></li>
				    <li class="list-group-item"><a href="<c:url value="/product/${product.id}"></c:url>" class="btn btn-primary btn-lg" role="button"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add to Cart</a></li>
				  </ul>
			</div>
		</div>
	</div>
</div>
</sf:form>
</div></body>
</html>