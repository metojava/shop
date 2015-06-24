<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
------------------------------------
<c:out value="${prod.name}"></c:out>
----------------------------------
<ul>
	<c:forEach items="${prods}" var="product">

<li>
		<c:out value="${product.name}"></c:out>
		<c:out value="${product.descr}"></c:out>
		<a href="product/${product.id}.htm">
		<img src="${product.picture}" width="100" height="100" />
		</a>
		
		<c:out value="${product.price}"></c:out>
</li>
	</c:forEach>
	</ul>
</body>
</html>