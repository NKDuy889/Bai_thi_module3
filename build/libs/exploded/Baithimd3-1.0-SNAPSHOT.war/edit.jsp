<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2/25/2021
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Product</h1>
<form method="post">
    <input type="hidden" name="name" value="${product.getName()}"/>
    <input type="text" name="price" value="${product.getPrice()}"/>
    <input type="text" name="quantity" value="${product.getQuantity()}"/>
    <input type="text" name="color" value="${product.getColor()}"/>
    <input type="text" name="descreption" value="${product.getDescreption()}"/>
    <input type="hidden" name="category" value="${product.getCategory()}"/>
    <button type="submit">Edit</button>
</form>
</body>
</html>
