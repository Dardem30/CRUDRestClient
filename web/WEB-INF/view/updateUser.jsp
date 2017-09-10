<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 07.09.2017
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form modelAttribute="user" action="/restController/updateUser" method="post">
    <input name="id" value="${user.id}" readonly="readonly"/>
    <input name="name" value="${user.name}"/>
    <input name="lastname" value="${user.lastname}"/>
    <input name="username" value="${user.username}"/>
    <input name="password" value="${user.password}"/>
    <input type="submit" value="ok"/>
</spring:form>
</body>
</html>
