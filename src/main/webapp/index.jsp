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
    <link rel="stylesheet" href="resources/chat/chat.css">
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
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
            <ul v-if="this.menuflag==true" class="logUl">
                <a href="/userPage">
                    <li  class="logLi">Профиль</li>
                </a>
                <a href="/Jopka">
                    <li class="logLi">Выйти</li>
                </a>
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
        <div class="col3">
            <div class="main-wrapper">
                <div class="headers">
                    <div class="header-message">Сообщения</div>
                    <div class="header-users-online">Юзеры онлайн</div>
                </div>

                <div class="chat-wrapper">
                    <div class="chat-text">
                        <ul class="messageUl">
                        </ul>
                    </div>
                    <div class="users">
                        <ul class="usersUl">
                        </ul>
                    </div>
                </div>

                <div class="send-message">
                    <textarea class="message" placeholder="Напечатайте сообщение..." maxlength="255" v-on:keyup.enter="newMessage()"></textarea>
                    <button class="send-button" v-on:click="newMessage()">Отправить</button>
                </div>
            </div>
        </div>
    </div>
    <footer></footer>
</div>
</body>
<script>

    var app = new Vue({
        el: '#app',
        data: {
            timerMessages: "",
            timerUsers: "",
            lastMessageId: 0,
            INDEX_WHISPER: 3,
            menuflag: false,
        },

        methods: {
            updateMessages: function () {
                var messageUl = document.getElementsByClassName('messageUl')[0];
                var params = new URLSearchParams();
                params.append('lastMessageId', this.lastMessageId);
                axios.post('/updateMessages', params, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                })
                    .then(response => {
                    var msgs = response.data;
                if (msgs.length>0) {
                    this.lastMessageId=msgs[msgs.length-1].idMessage;
                    for (var rowIndex = 0; rowIndex < msgs.length; rowIndex++) {
                        var newLi = document.createElement("li");
                        console.log(msgs[rowIndex].content)
                        if (msgs[rowIndex].content.substring(0,1)==="/"){
                            console.log(msgs[rowIndex].content)
                            newLi.textContent = msgs[rowIndex].content.substring(this.INDEX_WHISPER)
                            newLi.className = "whisper";
                        }else {
                            newLi.textContent = msgs[rowIndex].content;
                            newLi.className = "u" + msgs[rowIndex].idUser % 4;
                        }
                        messageUl.appendChild(newLi);
                    }
                    document.getElementsByClassName('chat-text')[0].scrollTop = 9999
                }
            })
            .catch(error => {
                    console.log(error.response)
            })
            },

            updateUsers: function () {
                var usersUl = document.getElementsByClassName('usersUl')[0];
                var params = new URLSearchParams();
                params.append('lastMessageId', "");
                axios.post('/updateOnlineUsers', params, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                })
                    .then(response => {
                    var onlineLogins = response.data;
                var textUsersUl = "";
                for (var rowIndex = 0; rowIndex < onlineLogins.length; rowIndex++) {
                    if (rowIndex == 0){
                        textUsersUl = onlineLogins[rowIndex].login
                    }else {
                        textUsersUl = textUsersUl + ' ' + onlineLogins[rowIndex].login
                    }
                }

                if (usersUl.textContent !== textUsersUl){
                    var newUi = document.createElement("ul");
                    for (var rowIndex = 0; rowIndex < onlineLogins.length; rowIndex++) {
                        var newLi = document.createElement("li");
                        newLi.textContent = onlineLogins[rowIndex].login;
                        newLi.className = "u" + onlineLogins[rowIndex].id % 4;
                        newUi.appendChild(newLi);
                    }
                    newUi.className = "usersUl";
                    document.getElementsByClassName('users')[0].replaceChild(newUi,usersUl);
                }
            })
            .catch(error => {
                    console.log(error.response)
            })
            },

            newMessage: function () {
                clearInterval(this.timerMessages);
                var params = new URLSearchParams();
                params.append('message', document.getElementsByClassName('message')[0].value);
                document.getElementsByClassName('message')[0].value = "";
                axios.post('/newMessage', params, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                })
                    .then(response => {
                    this.updateMessages();
            })
            .catch(error => {
                    console.log(error.response)
            })
                this.timerMessages = setInterval(function () {
                    this.updateMessages();
                }.bind(this), 2000);
            },

            keyEnter: function () {
                this.newMessage();
            },
            menuVisible: function () {
                this.menuflag = !this.menuflag;
            },
        },

        created: function () {
            this.timerMessages = setInterval(function () {
                this.updateMessages();
            }.bind(this), 2000);
            this.timerUsers = setInterval(function () {
                this.updateUsers();
            }.bind(this), 5000);
        },

    });


</script>
</html>