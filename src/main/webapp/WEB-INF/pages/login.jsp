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
    <link rel="stylesheet" href="/styles/style.css">
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

            <label class="input-label">Пароль</label>
            <input class="input-item" type="password" v-model="passUser">
            <%--<label v-if="problem != 'Всё ок'" style="color:red">{{problem}}</label>--%>

            <div class="send-btn-wrapper">
                <div class="send-btn-main" v-on:click="topLogining()">Войти</div>
            </div>
        </div>
    </div>


    <form action="/j_username_security_check" method="post" style="display: none">
        <h2>Вход в систему</h2>
        <input type="text" name="j_username" placeholder="Input your login" required :value="loginUser"><br>
        <input type="password" name="j_password" placeholder="Input your password" required :value="passUser">
        <input type="submit" ref="form" value="Login">
    </form>

</div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            loginUser: "",
            passUser: "",
            problem: ""
        },
        methods: {

            topLogining: function () {
                this.$refs.form.click();
            },

            enter: function () {
                var params = new URLSearchParams();
                params.append('j_username', this.loginUser);
                params.append('j_password', this.passUser);
                axios.post('/j_username_security_check', params, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                        'Upgrade-Insecure-Requests': 1

                    }
                })
                    .then(response = > {
                    console.log(response)

            })
            .
                catch(error = > {
                    console.log(error.response)
            })
            }
        }
    });
</script>
</html>

<%--methods: {--%>
<%--enter: function(){--%>
<%--data.append('j_username', this.loginUser);--%>
<%--data.append('j_password', this.passUser);--%>
<%--axios.post('/j_username_security_check', data, {--%>
<%--headers: {--%>
<%--'Content-Type': 'multipart/form-data'--%>
<%--})--%>
<%--.then(response => {--%>
<%--//     console.log(response.data);--%>
<%--// this.problem = response.data;--%>
<%--})--%>
<%--}--%>
<%--}}--%>