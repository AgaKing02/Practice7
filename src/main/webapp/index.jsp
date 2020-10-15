<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 14.10.2020
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action='<%=request.getContextPath()+"/login"%>' method="get">
    <label for="user-name-label">Username :</label>
    <input type="text" name="username" placeholder="Username" id="user-name-label">
    <br>
    <label for="password-label">Password :</label>
    <input type="password" name="password" id="password-label">
    <br>
    <input type="submit" value="Log in">
</form>
</body>
</html>
