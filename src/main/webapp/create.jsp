<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2/25/2021
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  method="post">
<tabe>
    <tr><td>Name<input type="text" name="name"></td></tr>
    <td>Price<input type="text" name="price"></td>
    <td>Quantity<input type="text" name="quantity"></td>
    <td>Color<input type="text" name="color"></td>
    <td>Descreption<input type="text" name="descreption"></td>
    <td><input type="hidden" name="category" value="phone"></td>
    <td><button type="submit">Save</button></td>
    <td><a href="/product">List product</a></td>
</tabe>
</form>
</body>
</html>
