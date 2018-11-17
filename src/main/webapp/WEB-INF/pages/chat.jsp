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
<head>
    <link rel="stylesheet" href="resources/chat/chat.css">
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
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
            <ul>
                <li class="mushen">mushen</li>
                <li class="unclepetr">unclepetr</li>
                <li class="sylar47">sylar47</li>

            </ul>
        </div>
    </div>

    <div class="send-message">
        <textarea class="message" placeholder="Напечатайте сообщение..." maxlength="255"></textarea>
        <button class="send-button" v-on:click="newMessage()">Чтобы отправить сообщение нажмите ENTER</button>
    </div>

    <%--    <div>
            <button v-on:click="updateMessages()">ОБНОВИТЬ СООБЩЕНИЯ</button>
        </div>--%>

</div>


</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            /*var nLi = document.createElement("li"),*/
            timerId: "",

        },

        methods: {

            updateMessages: function () {
                var messageUl = document.getElementsByClassName('messageUl')[0];
                var params = new URLSearchParams();
                params.append('message', document.getElementsByClassName('message')[0].value);
                axios.post('/updateMessages', params, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                })
                    .then(response = > {
                    var msgs = response.data;
                for (var rowIndex = 0; rowIndex < msgs.length; rowIndex++) {
                    var newLi = document.createElement("li");
                    newLi.textContent = msgs[rowIndex].content;
                    newLi.className = "u" + msgs[rowIndex].idUser % 4;
                    messageUl.appendChild(newLi);
                }
                document.getElementsByClassName('chat-text')[0].scrollTop = 9999
            })
            .
                catch(error = > {
                    console.log(error.response)
            })
                ;
            },


            newMessage: function () {
                var params = new URLSearchParams();
                params.append('message', document.getElementsByClassName('message')[0].value);
                document.getElementsByClassName('message')[0].value = "";
                axios.post('/newMessage', params, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                })
                    .then(response = > {
                    this.updateMessages();
            })
            .
                catch(error = > {
                    console.log(error.response)
            })
                ;

            }

        },

        created: function () {
            this.timerId = setInterval(function () {
                this.updateMessages();
            }.bind(this), 2000);
        },

    });
</script>
</html>
