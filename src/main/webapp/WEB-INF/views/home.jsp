<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="styles/styles.css" rel="stylesheet" type="text/css">

<html>
<head>
    <title>Product Manager</title>
</head>

<body>

<div class="products" align="center">
    <h1>Product Manager</h1>
    <form method="get" action="search">
        <input type="text" name="keyword" placeholder="Name"/>
        <input type="submit" value="Submit"/>
    </form>
    <h3><a href="new">New Product</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Brand</th>
            <th>Country</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.brand}</td>
                <td>${product.country}</td>
                <td>${product.price}</td>
                <td><a href="delete?id=${product.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>

</html>