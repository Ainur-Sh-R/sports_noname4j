<%--
  Created by IntelliJ IDEA.
  User: Кирилл
  Date: 04.11.2018
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/styles/style.css">
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

        <div class="input-group-main">
            <label class="input-label">Логин</label>
            <input class="input-item" type="text" v-model="loginUser">

            <label class="input-label">ФИО</label>
            <input class="input-item" type="text" v-model="name">

            <label class="input-label">mail</label>
            <input class="input-item" type="text" v-model="mail">

            <label class="input-label">Пароль</label>
            <input class="input-item" type="password" v-model="passUser">

            <div class="send-btn-wrapper">
                <div class="send-btn-main" v-on:click="">Зарегистрироваться</div>
            </div>
        </div>
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
            passUser: "",
            name: "",
            mail: ""
        }
    })
</script>
</html>
