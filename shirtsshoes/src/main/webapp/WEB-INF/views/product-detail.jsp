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
<body><div class="container">
<jsp:include page="header.jsp"><jsp:param value="product" name="actTab"/></jsp:include>

<h2>${product.name}</h2>
<h3>${product.description}</h3>
<sf:form class="form-horizontal" role="form" modelAttribute="product">
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Name</label>
    <div class="col-sm-10">
      <sf:input path="name" id="name" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Description</label>
    <div class="col-sm-10">
      <sf:input path="description" id="description" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Category</label>
    <div class="col-sm-10">
      <sf:input path="category" id="category" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Price</label>
    <div class="col-sm-10">
      <sf:input path="price" id="price" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label for="available"><sf:checkbox path="available" id="available"/>Available</label>
      </div>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Submit</button>
      <a href='<c:url value="/product"></c:url>'><button type="button" class="btn btn-success">Cancel</button></a>
    </div>
  </div>
</sf:form>
</div></body>
</html>