<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"></c:url>">
</head>

<body>

<jsp:include page="header.jsp"><jsp:param value="product" name="actTab"/></jsp:include>

<div class="container">

<div class="row">
  
  <c:forEach items="${products}" var="product">
  	<a href="<c:url value="/product/${product.id}"></c:url>">
	  <div class="col-sm-6 col-md-4" >
	    <div class="thumbnail" >
	      <img style="max-width:250px;max-height: 250px;min-width: 250px;min-height: 250px;" src='<c:url value="/resources/img/${product.fileName}"></c:url>' alt="${product.name}">
	      <div class="caption">
	        <h3>${product.name}</h3>
	      </div>
	    </div>
	  </div>
	  </a>
  </c:forEach>
  
</div>



</div>


</body>


</html>
