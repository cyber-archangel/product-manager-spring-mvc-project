<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>New Product</title>
</head>

<body>

<div align="center">
    <h1>New Product</h1>
    <form:form action="save" method="post" modelAttribute="product">
        <table border="0" cellpadding="5">
            <tr>
                <td>Name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Brand:</td>
                <td><form:input path="brand"/></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><form:input path="country"/></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><form:input path="price"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>
</div>

</body>

</html>