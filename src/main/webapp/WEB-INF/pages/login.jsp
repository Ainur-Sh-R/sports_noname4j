<%--
  Created by IntelliJ IDEA.
  User: m.biryukov
  Date: 24.10.2018
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<form action="/j_username_security_check" method="post">
    <h2>Вход в систему</h2>
    <input type="text" name="j_username" placeholder="Input your login" required><br>
    <input type="password" name="j_password" placeholder="Input your password" required>
    <input type="submit" value="Login">
</form>
</body>
</html>