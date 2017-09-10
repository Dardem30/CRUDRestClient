<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 30.08.2017
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/restController/listUser">listUser</a>
<form method="get" action="/restController/user/id">
    <input name="id" type="text">
    <input type="submit" value="ok">
</form>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>lastname</td>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.lastname}</td>
            <td><a href="/updateUser/id?id=${user.id}">update</a></td>
            <td><a href="/restController/deleteUser/id?id=${user.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
