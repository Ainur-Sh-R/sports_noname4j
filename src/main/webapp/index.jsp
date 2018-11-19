<%--
  Created by IntelliJ IDEA.
  User: Кирилл
  Date: 04.11.2018
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/style.css">
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <title>$Title$</title>
</head>
<body>
<div id="app">
    <div class="element-up">
        <div></div>
        <div class="head">
            <h3 style="margin-right: 120px;">Ставки на спорт</h3>
        </div>
    </div>
    <div class="element-down">

        <p><a href="/login">авторизация</a></p>
        <p><a href="/registr">регистрация</a></p>

    </div>
</div>
</div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            message: 'Привет, Vue!',
            loginUser: "",
            passUser: ""
        }
    })
</script>
</html>

