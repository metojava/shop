<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<c:url value="css/style.css"/>" >

<link rel="stylesheet" type="text/css" href="<c:url value="css/bootstrap.min.css"/>">
<script type="text/javascript" src="<c:url value="js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/bootstrap.min.js"/>"></script>


<title>Products</title>
</head>
<body>

<div class="container">

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">

<a href="#" class="brand">Toshima</a>
            <ul role="navigation" class="nav">
               
                <li><a href="#">Products</a></li>
<li><a href="#" onclick="gethomes()" >Homes</a></li>
<li><a href="#">Cars</a></li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Messages <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Inbox</a></li>
                        <li><a href="#">Drafts</a></li>
                        <li><a href="#">Sent Items</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Trash</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav pull-right">
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">Admin <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Settings</a></li>
                    </ul>
                </li>
            </ul>


<form class="navbar-form pull-right">
                <input type="text" placeholder="Search" class="input-medium search-query">
                <button class="btn" type="submit">Search</button>
            </form>

    </div>

    </div>



<div class="hero-unit">
<img src="logo.png" width='100' height='100' />
<h1>Toshima's Best</h1>
<h5>Change your life to the best</h5>
<br>
<a href="#" class="btn btn-large btn-success">Get Started</a>
</div>
<div id="cont">

------------------------------------
<c:out value="${prod.name}"></c:out>
----------------------------------


<ul class='thumbnails'>
	<c:forEach items="${prods}" var="product">

<li class='span3'>
<div class='caption'>
		<c:out value="${product.name}"></c:out>
		<c:out value="${product.descr}"></c:out>
		<c:out value="${product.price}"></c:out>
		</div>
		<a href="product/${product.id}.htm">
		<img src="${product.picture}" width="100" height="100" />
		</a>
		
		
</li>
	</c:forEach>
	</ul>
	
</div>


</div>
<br/>
<br/>
<br/>
<div id="footer">
<center>
CopyRight 2015 @MyDesigns
</center>
</div>

</div>	
</body>
</html>