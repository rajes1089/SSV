<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String actTab = request.getParameter("actTab"); %>
<nav class="navbar navbar-inverse">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Shirts And Shoes</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav ">
        <li class="<%=(actTab.equals("product"))?"active":""%>" ><a href='<c:url value="/product"></c:url>'>Products</a></li>
        <li class="<%=(actTab.equals("customer"))?"active":""%>" ><a href='<c:url value="/customer"></c:url>'>Customers</a></li>
      </ul>
     
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Sign In</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
</nav>