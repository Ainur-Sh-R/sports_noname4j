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
    <link rel="stylesheet" href="/resources/style.css">
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
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
                <div class="send-btn-main" v-on:click="registr">Зарегистрироваться</div>
            </div>
        </div>
    </div>

    <form action="/addUser" method="post" style="display: none">
        <input type="text" name="userLogin" required :value="loginUser"><br/>
        <input type="text" name="userPassword" required :value="passUser"><br/>
        <input type="text" name="userFullName" required :value="name"><br/>
        <input type="text" name="userMail" required :value="mail"><br/>
        <input type="submit" ref="form">
    </form>

</div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            loginUser: "",
            passUser: "",
            name: "",
            mail: ""
        },
        methods: {
            registr: function () {
                this.$refs.form.click();
            }
        }
    });


</script>
</html>
