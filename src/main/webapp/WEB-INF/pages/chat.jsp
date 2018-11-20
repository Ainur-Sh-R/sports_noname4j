<%--
  Created by IntelliJ IDEA.
  User: Mushen
  Date: 13.11.2018
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="utf-8">
<head>
    <link rel="stylesheet" href="resources/chat/chat.css">
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <link rel="shortcut icon" href="#">
    <title>Чат</title>


</head>
<body>


<div class="main-wrapper" id="app">
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
        <button class="send-button" v-on:click="newMessage()">Чтобы отправить сообщение нажмите ENTER</button>
    </div>
</div>


</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            timerMessages: "",
            timerUsers: "",
            lastMessageId: 0,
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
                        newLi.textContent = msgs[rowIndex].content;
                        newLi.className = "u" + msgs[rowIndex].idUser % 4;
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
