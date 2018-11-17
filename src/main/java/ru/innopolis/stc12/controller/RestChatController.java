package ru.innopolis.stc12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.stc12.bd.pojo.Message;
import ru.innopolis.stc12.bd.pojo.RestChatPojo;
import ru.innopolis.stc12.service.ServiceChat;
import ru.innopolis.stc12.service.ServiceUsers;

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
            message.setContent(principal.getName() + ": " + newMessage);
            message.setDateCreate(new Date());
            message.setIdChat(1);
            message.setIdUser(serviceUsers.getIdByLogin(principal.getName()));
            serviceChat.addMessage(message);
        }
        return new RestChatPojo(String.format(template, message), counter.incrementAndGet());
    }

    @RequestMapping("/updateMessages")
    public List<Message> getNewMessages(
            HttpSession session) {
        int lastId;

        if (session.getAttribute("lastMessageId") == null) {
            session.setAttribute("lastMessageId", 0);
        }

        List<Message> list = serviceChat.getNewMessages((Integer) session.getAttribute("lastMessageId"));
        if (list.size() > 0) {
            session.setAttribute("lastMessageId", list.get(list.size() - 1).getIdMessage());
        }

        return list;
    }
}

/*
return new RestChatPojo(String.format(template, message),counter.incrementAndGet());*/
