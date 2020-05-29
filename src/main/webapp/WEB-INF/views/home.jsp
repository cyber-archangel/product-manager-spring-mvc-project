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
        <input type="text" name="keyword" placeholder="Search"/>
        <input type="submit" value="Submit"/>
    </form>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Brand</th>
            <th>Country</th>
            <th>Price</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.brand}</td>
                <td>${product.country}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>

</html>