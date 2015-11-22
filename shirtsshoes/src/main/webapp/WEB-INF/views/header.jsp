<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String actTab = request.getParameter("actTab"); %>
<nav class="navbar navbar-default">
<div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href='<c:url value="/"></c:url>'>Shirts And Shoes</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav ">
        <li class="<%=(actTab.equals("product"))?"active":""%>" ><a href='<c:url value="/product"></c:url>'>Products</a></li>
        <li class="<%=(actTab.equals("customer"))?"active":""%>" ><a href='<c:url value="/customer"></c:url>'>Customers</a></li>
        <li class="<%=(actTab.equals("order"))?"active":""%>" ><a href='<c:url value="/order"></c:url>'>Orders</a></li>
      </ul>
     
      <ul class="nav navbar-nav navbar-right">
	      <li>
	      <form class="navbar-form navbar-left" action='<c:url value="/product/search"></c:url>' role="search">
	        <div class="form-group">
	          <input type="text" class="form-control" name="productSearch" placeholder="Search">
	        </div>
	        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Submit</button>
	      </form>
	      </li>
        <li><a href="#">Sign In</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
 </div>
</nav>