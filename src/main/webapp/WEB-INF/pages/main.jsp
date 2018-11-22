<%--
  Created by IntelliJ IDEA.
  User: Kirill
  Date: 23.11.2018
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="resources/main.css">
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<div id="app">
    <header>
        <!-- <img src="img/logo.svg" class="logo-ma"> -->
        <div class="head-info">
            <p class="title-profile">ОКНО ПРИВЕТСТВИЯ</p>
        </div>
        <div class="menu">
            <img src="img/user.svg" class="logo-man" v-on:click="menuVisible">
            <ul v-if="this.menuflag==true">
                <a href="/userPage">
                    <li>Профиль</li>
                </a>
                <li>Выйти</li>
            </ul>
        </div>
    </header>
    <div class="main">
        <div class="col1">
            <p>Успешных прогнозов: 40 </p>
            <p>Неуспешных прогнозов: 10</p>
        </div>
        <div class="col2">

            <table>
                <tbody>
                <tr>
                    <td>08.07.2018 22:30</td>
                    <td>46'</td>
                    <td></td>
                    <td>Ювентус</td>
                    <td>2</td>
                    <td>:</td>
                    <td>0</td>
                    <td>Милан</td>
                </tr>
                <tr>
                    <td>08.07.2018 22:30</td>
                    <td>46'</td>
                    <td></td>
                    <td>Лестер</td>
                    <td>1</td>
                    <td>:</td>
                    <td>0</td>
                    <td>Челси</td>
                </tr>
                <tr>
                    <td>08.07.2018 22:30</td>
                    <td>12'</td>
                    <td></td>
                    <td>Краснодар</td>
                    <td>3</td>
                    <td>:</td>
                    <td>0</td>
                    <td>Барселона</td>
                </tr>
                </tbody>
            </table>

        </div>
        <div class="col3">Чат</div>
    </div>
    <footer></footer>
</div>
</body>
<script>
    let vueApp = new Vue({
        el: '#app',
        data: {
            menuflag: false,
        },
        methods: {
            menuVisible: function () {
                this.menuflag = !this.menuflag;
            }
        }
    })
</script>
</html>

