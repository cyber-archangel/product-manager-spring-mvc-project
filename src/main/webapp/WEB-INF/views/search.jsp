<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="styles/styles.css" rel="stylesheet" type="text/css">

<html>
<head>
    <title>Search Result</title>
</head>

<body>

<div class="products" align="center">
    <h1>Search Result</h1>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Brand</th>
            <th>Country</th>
            <th>Price</th>
        </tr>
        <c:forEach var="product" items="${result}">
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