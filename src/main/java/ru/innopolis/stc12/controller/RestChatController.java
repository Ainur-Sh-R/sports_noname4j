package ru.innopolis.stc12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.stc12.bd.pojo.Message;
import ru.innopolis.stc12.bd.pojo.OnlineLogin;
import ru.innopolis.stc12.bd.pojo.RestChatPojo;
import ru.innopolis.stc12.bd.pojo.User;
import ru.innopolis.stc12.service.ServiceChat;
import ru.innopolis.stc12.service.ServiceUsers;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestChatController {

    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();
    private ServiceChat serviceChat;
    private ServiceUsers serviceUsers;

    @Autowired
    public RestChatController(ServiceChat serviceChat, ServiceUsers serviceUsers) {
        this.serviceChat = serviceChat;
        this.serviceUsers = serviceUsers;
    }

    @RequestMapping("/newMessage")
    public RestChatPojo newMessage(
            @RequestParam(value = "message", required = false, defaultValue = "") String newMessage,
            Principal principal) {
        Message message = new Message();
        if (newMessage != "") {

            try {
                message.setContent(new String((principal.getName() + ": " + newMessage).getBytes("ISO-8859-1"), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                message.setContent(principal.getName() + ": " + newMessage);
            }
            message.setDateCreate(new Date());
            message.setIdChat(1);
            message.setIdUser(serviceUsers.getIdByLogin(principal.getName()));
            serviceChat.addMessage(message);
        }
        return new RestChatPojo(String.format(template, message), counter.incrementAndGet());
    }

    @RequestMapping("/updateMessages")
    public List<Message> getNewMessages(
            @RequestParam(value = "lastMessageId") Integer lastMessageId,
            HttpSession session) {
        int lastId;
        return serviceChat.getNewMessages(lastMessageId);
    }

    @RequestMapping("/updateOnlineUsers")
    public List<User> getOnlineUsers(){
        return serviceUsers.getOnlineLogins();
    }

}

/*
return new RestChatPojo(String.format(template, message),counter.incrementAndGet());*/
