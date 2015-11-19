<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Info</title>
<link rel="stylesheet"  href="<c:url value="/resources/css/bootstrap.min.css"></c:url>">
</head>
<body class="container">

<jsp:include page="header.jsp"><jsp:param value="customer" name="actTab"/></jsp:include>

<h3>Customer Info</h3>

<sf:form class="form-horizontal" role="form" modelAttribute="customer">
  <div class="form-group">
    <label class="control-label col-sm-2" for="firstName">First Name</label>
    <div class="col-sm-10">
      <sf:input path="firstName" id="firstName" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="lastName">Last Name</label>
    <div class="col-sm-10">
      <sf:input path="lastName" id="lastName" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="streetAddress1">Street Address1</label>
    <div class="col-sm-10">
      <sf:input path="streetAddress1" id="streetAddress1" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="streetAddress2">Street Address2</label>
    <div class="col-sm-10">
      <sf:input path="streetAddress2" id="streetAddress2" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="city">City</label>
    <div class="col-sm-10">
      <sf:input path="city" id="city" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="state">State</label>
    <div class="col-sm-10">
      <sf:input path="state" id="state" cssClass="form-control"/>
    </div>
  </div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="postalCode">Postal Code</label>
    <div class="col-sm-10">
      <sf:input path="postalCode" id="postalCode" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="phoneNumber1">Primary Phone</label>
    <div class="col-sm-10">
      <sf:input path="phoneNumber1" id="phoneNumber1" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="phoneNumber2">Alternate Phone</label>
    <div class="col-sm-10">
      <sf:input path="phoneNumber2" id="phoneNumber2" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="creditLimit">Credit Limit</label>
    <div class="col-sm-10">
      <sf:input path="creditLimit" id="creditLimit" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Email</label>
    <div class="col-sm-10">
      <sf:input path="email" id="email" cssClass="form-control"/>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Submit</button>
      <a href='<c:url value="/customer"></c:url>'><button type="button" class="btn btn-success">Cancel</button></a>
    </div>
  </div>
</sf:form>
</body>
</html>