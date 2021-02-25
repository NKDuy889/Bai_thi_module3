<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2/25/2021
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <title>List Products</title>
</head>
<body>
<form>
    <a href="/product?action=create">Create</a>
</form>

<form style="width: 60px; margin-top: 20px" >
    <input name="action" hidden value="search">
    <input type="search" name="search" style="width: 250px">
    <button type="submit" class="btn btn-primary">Search</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
        <th scope="col">Color</th>
        <th scope="col">Descreption</th>
        <th scope="col">Category</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${product}" varStatus="loop">
    <tr>
        <td>${c.getName()}</td>
        <td>${c.getPrice()}</td>
        <td>${c.getQuantity()}</td>
        <td>${c.getColor()}</td>
        <td>${c.getDescreption()}</td>
        <td>${c.getCategory()}</td>

        <td>
            <form method="get">
            <a href="/product?action=edit&id=${c.getId()}">Edit</a>
            </form>
        </td>
        <td>
            <a href="/product?action=delete&id=${c.getId()}">Delete</a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>






<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
        integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
        integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
        crossorigin="anonymous"></script>
</body>
</html>
