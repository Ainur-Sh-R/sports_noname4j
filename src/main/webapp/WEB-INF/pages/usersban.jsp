<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Users Ban Form</title>

</head>
<body>

<table border="1"
       cellspacing="1"
       cellpadding="5"
       style="border-collapse: collapse"
        >
    <caption>Все пользователи системы</caption>
    <TR>
        <td>User ID</td>
        <td>Login</td>
        <td>Full Name</td>
        <td>e-mail</td>
        <td>Enabled</td>
        <td>Role</td>
    </TR>

    <c:forEach var="user" items="${userlist}">
        <TR>
            <TD>${user.getId()}</TD>
            <TD>${user.getLogin()}</TD>
            <TD>${user.getFullName()}</TD>
            <TD>${user.getMail()}</TD>
            <TD>${user.getEnabled()}</TD>
            <TD>${user.getRole()}</TD>
        </TR>
    </c:forEach>

</table>

<br>

<form action="banUser" method="post">
    <input type="text" name="userBanId" placeholder="user Id">
    <input type="submit" value="Бан пользователя"/>
</form>

<br>
<form action="banUserCancel" method="post">
    <input type="text" name="userBanId" placeholder="user Id">
    <input type="submit" value="Снять бан пользователя"/>
</form>


</body>
</html>
